package com.example.Ejercicio.DB0.Persona.application;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Errores.UnprocesableException;
import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Repository.Estudianterepo;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaListOutputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaProfesorDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaStudentDTO;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Repository.Personarepo;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Repository.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    Personarepo personarepo;

    @Autowired
    Estudianterepo estudianterepo;

    @Autowired
    ProfesorRepo profesorRepo;


    @Override
    public PersonaoutputDTO addPerson(PersonainputDTO personainputDTO) throws Exception {

          this.validar(personainputDTO);

          PersonaoutputDTO personaoutputDTO= new PersonaoutputDTO(personarepo.save(convertInputtoEntity(personainputDTO)));

        return personaoutputDTO;

    }



    @Override
    public PersonaoutputDTO findPersonaid(String id, String outputType) throws PersonNotFoundException {
        Persona persona = personarepo.findById(id).orElseThrow(() -> new PersonNotFoundException("No hay ninguna persona con ID " + id));
        if (outputType.equalsIgnoreCase("full")) {
            List<Estudiante> estudiantes = estudianterepo.findAll();
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getPersona().getId_persona().equals(persona.getId_persona())) {
                    return new PersonaStudentDTO(persona, estudiante);
                }
            }


            List<Profesor> profesores = profesorRepo.findAll();
            for (Profesor profesor : profesores) {
                if (profesor.getPersona().getId_persona().equals(persona.getId_persona())) {
                    return new PersonaProfesorDTO(persona, profesor);
                }
            }
            return new PersonaoutputDTO(persona);

        } else {
            return new PersonaoutputDTO(persona);
        }
    }

    @Override
    public PersonaListOutputDTO findUsuario(String usuario, String outputType) {

        List<Persona> personaList= (personarepo.findByUsuario(usuario));

         return convertToListaOutputDTO(personaList,outputType);
    }

    @Override
    public PersonaListOutputDTO getUsuarios(String outputType) {

        List<Persona> personas= personarepo.findAll();

        return convertToListaOutputDTO(personas,outputType);
    }

    @Override
    public PersonaoutputDTO setPerson(PersonainputDTO personainputDTO, String id) throws UnprocesableException, PersonNotFoundException {

        this.validar(personainputDTO);
       Persona persona= personarepo.findById(id).orElseThrow(()->new PersonNotFoundException("No se ha encontrado la persona con el id"+id));
       persona.setUsuario(personainputDTO.getUsuario());
       persona.setPassword(personainputDTO.getPassword());
       persona.setCity(personainputDTO.getCity());
       persona.setPersonal_email(personainputDTO.getPersonal_email());
       persona.setCompany_email(personainputDTO.getCompany_email());
       persona.setName(personainputDTO.getName());
       persona.setSurname(personainputDTO.getSurname());
       persona.setImagen_url(personainputDTO.getImagen_url());
       persona.setTermination_date(personainputDTO.getTermination_date());
       persona.setCreated_date(personainputDTO.getCreated_date());
       personarepo.save(persona);
       return this.convertToDTO(persona);
    }

    @Override
    public void deletePerson(String id) throws PersonNotFoundException, UnprocesableException {
        Persona persona= personarepo.findById(id).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado la persona"));
        if (persona.getEstudiante()!=null) throw  new UnprocesableException("La persona es un estudiante");
        if (persona.getProfesor()!=null) throw new UnprocesableException("La persona es un profesor");
        personarepo.delete(persona);

    }

    private PersonaListOutputDTO convertToListaOutputDTO(List<Persona> lista, String outputType){
        List<PersonaoutputDTO> personaoutputDTOList= new ArrayList<>();

        List<Estudiante> estudiantes = estudianterepo.findAll();
        List<Profesor> profesores = profesorRepo.findAll();

        if (outputType.equalsIgnoreCase("full")){
            for (Persona persona:lista) {
                boolean found= false;
                for (Estudiante estudiante : estudiantes) {
                    if (persona.getId_persona().equals(estudiante.getPersona().getId_persona()) && !found){
                        personaoutputDTOList.add(new PersonaStudentDTO(persona,estudiante));
                        found=true;
                    }
                }
                for (Profesor profesor:profesores){
                    if (persona.getId_persona().equals(profesor.getPersona().getId_persona()) && !found){
                        personaoutputDTOList.add(new PersonaProfesorDTO(persona,profesor));
                        found=true;
                    }
                }
                if (!found){
                    personaoutputDTOList.add(new PersonaoutputDTO(persona));
                }
            }

        } else {
            for (Persona persona:lista){
                personaoutputDTOList.add(new PersonaoutputDTO(persona));
            }
        }
        PersonaListOutputDTO listOutputDTO= new PersonaListOutputDTO();

        listOutputDTO.setLista(personaoutputDTOList);

        return listOutputDTO;
    }

    public void checkPassword(String usuario, String password){
        Persona persona= (personarepo.findByUsuario(usuario)).get(0);
        if (!persona.getPassword().equals(password)) throw new UnprocesableException("La contraseña no es correcta");

    }

    private  PersonaoutputDTO convertToDTO(Persona persona){
        PersonaoutputDTO personaoutputDTO= new PersonaoutputDTO();
        personaoutputDTO.setId_persona(persona.getId_persona());
        personaoutputDTO.setUsuario(persona.getUsuario());
        personaoutputDTO.setCity(persona.getCity());
        personaoutputDTO.setPersonal_email(persona.getPersonal_email());
        personaoutputDTO.setActive(persona.isActive());
        personaoutputDTO.setCreated_date(persona.getCreated_date());
        personaoutputDTO.setSurname(persona.getSurname());
        personaoutputDTO.setName(persona.getName());
        personaoutputDTO.setCompany_email(persona.getCompany_email());
        personaoutputDTO.setImagen_url(persona.getImagen_url());
        personaoutputDTO.setTermination_date(persona.getTermination_date());
        personaoutputDTO.setAdmin(persona.isAdmin());
        return personaoutputDTO;
    }

    private Persona convertInputtoEntity(PersonainputDTO personainputDTO){
        Persona persona= new Persona();
        persona.setUsuario(personainputDTO.getUsuario());
        persona.setPassword(personainputDTO.getPassword());
        persona.setCity(personainputDTO.getCity());
        persona.setPersonal_email(personainputDTO.getPersonal_email());
        persona.setActive(personainputDTO.isActive());
        persona.setCreated_date(personainputDTO.getCreated_date());
        persona.setSurname(personainputDTO.getSurname());
        persona.setName(personainputDTO.getName());
        persona.setCompany_email(personainputDTO.getCompany_email());
        persona.setImagen_url(personainputDTO.getImagen_url());
        persona.setTermination_date(personainputDTO.getTermination_date());
        persona.setAdmin(personainputDTO.isAdmin());
        return  persona;

    }

    private void validar(PersonainputDTO personainputDTO) throws UnprocesableException{
        String usuario= personainputDTO.getUsuario();

        if (usuario==null) throw new UnprocesableException("Usuario no puede ser nulo");
        if (usuario.length()>10 || usuario.length()<6) throw new UnprocesableException("El usuario debe tener entre 6 y 10 caracteres");;
        if (personainputDTO.getPassword()==null) throw new UnprocesableException("Se debe introducir una contraseña");
        if (personainputDTO.getCreated_date()==null) throw new UnprocesableException("Se debe introducir una fecha");
    }


}



