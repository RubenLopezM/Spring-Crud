package com.example.Ejercicio.DB0.Persona.application;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Errores.UnprocesableException;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Repository.Personarepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    Personarepo personarepo;


    @Override
    public PersonaoutputDTO addPerson(PersonainputDTO personainputDTO) throws Exception {

          this.validar(personainputDTO);

          PersonaoutputDTO personaoutputDTO= new PersonaoutputDTO(personarepo.save(convertInputtoEntity(personainputDTO)));

        return personaoutputDTO;

    }



    @Override
    public PersonaoutputDTO findPersonaid(Integer id) throws PersonNotFoundException {
        PersonaoutputDTO persona = new PersonaoutputDTO(personarepo.findById(id).orElseThrow(()->new PersonNotFoundException("No hay ninguna persona con ID:"+id))) ;
        return persona;

    }

    @Override
    public List<PersonaoutputDTO> findUsuario(String usuario) {

        return personarepo.buscaPorNombre(usuario, PageRequest.of(0,5));
    }

    @Override
    public List<PersonaoutputDTO> getUsuarios() {
        List<PersonaoutputDTO> personaoutputDTOS=new ArrayList<>();
        List<Persona> personas= personarepo.findAll();
        for(Persona persona:personas) personaoutputDTOS.add(this.convertToDTO(persona));
        return personaoutputDTOS;
    }

    @Override
    public PersonaoutputDTO setPerson(PersonainputDTO personainputDTO, Integer id) throws UnprocesableException, PersonNotFoundException {

        this.validar(personainputDTO);
       Persona persona= personarepo.findById(id).orElseThrow(()->new PersonNotFoundException("No se ha encontrado el registro"));
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
    public void deletePerson(Integer id) throws PersonNotFoundException {
        Persona persona= personarepo.findById(id).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado la persona"));
        personarepo.delete(persona);

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
        return  persona;

    }

    private void validar(PersonainputDTO personainputDTO) throws UnprocesableException{
        String usuario= personainputDTO.getUsuario();

        if (usuario==null) throw new UnprocesableException("Error: Usuario no puede ser nulo");
        if (usuario.length()>10 || usuario.length()<6) throw new UnprocesableException("Error: El usuario debe tener entre 6 y 10 caracteres");;
        if (personainputDTO.getPassword()==null) throw new UnprocesableException("Error: Se debe introducir una contraseña");
    }
}



