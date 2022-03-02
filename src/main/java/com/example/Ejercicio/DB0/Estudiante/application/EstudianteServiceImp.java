package com.example.Ejercicio.DB0.Estudiante.application;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Errores.UnprocesableException;
import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteFullOutputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Repository.Estudianterepo;
import com.example.Ejercicio.DB0.EstudianteAsignatura.domain.Estudiante_Asignatura;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaListaOuput;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaOutputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Repository.EstudianteAsignaturaRepo;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Repository.Personarepo;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.input.ProfesorInputDTO;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Repository.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteServiceImp implements EstudianteService {

    @Autowired
    Personarepo personarepo;

    @Autowired
    Estudianterepo estudianterepo;

    @Autowired
    ProfesorRepo profesorRepo;

    @Autowired
    EstudianteAsignaturaRepo estudianteAsignaturaRepo;


    public EstudianteOutputDTO addEstudiante(EstudianteinputDTO estudianteinputDTO){

        checkEstudiante_Profesor(estudianteinputDTO);

        Estudiante estudiante= estudianterepo.save(convertoEstudiante(estudianteinputDTO));


        EstudianteOutputDTO estudianteOutputDTO= new EstudianteOutputDTO(estudiante);
        return estudianteOutputDTO;

    }

    @Override
    public EstudianteOutputDTO findEstudiante(String id, String outputType) throws PersonNotFoundException {
        Estudiante estudiante= estudianterepo.findById(id).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado este registro"));

         if (outputType.equalsIgnoreCase("full")){
            return new EstudianteFullOutputDTO (estudiante);
        } else {
            return new EstudianteOutputDTO(estudiante);
        }
    }

    @Override
    public EstudianteOutputDTO setEstudiante(EstudianteinputDTO estudianteinputDTO, String id) throws PersonNotFoundException {
        Estudiante estudiante= estudianterepo.findById(id).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado este registro"));
          estudiante.setBranch(estudianteinputDTO.getBranch());
          estudiante.setNum_horas_semana(estudianteinputDTO.getNum_horas_semana());
          estudiante.setComentarios(estudianteinputDTO.getComentarios());
          estudianterepo.save(estudiante);
          return new EstudianteOutputDTO(estudiante);
    }

    @Override
    public void deleteEstudiante(String id) throws PersonNotFoundException {
        Estudiante estudiante= estudianterepo.findById(id).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado este registro"));
          estudianterepo.delete(estudiante);
    }

    @Override
    public EstudianteAsignaturaListaOuput addAsignaturas(String id, List<EstudianteAsignaturaInputDTO> list) {
        Estudiante estudiante= estudianterepo.findById(id).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado este registro"));

        List<EstudianteAsignaturaOutputDTO> listaOuputDTO = new ArrayList<>();
        for (EstudianteAsignaturaInputDTO inputDTO:list) {
            Profesor profesor = profesorRepo.findById(inputDTO.getId_profesor())
                    .orElseThrow(()->new UnprocesableException("No se ha encontrado este registro"));

            Estudiante_Asignatura asignatura = inputDTO.convertToEstudianteAsignatura(estudiante,profesor);
            estudianteAsignaturaRepo.save(asignatura);
            listaOuputDTO.add(new EstudianteAsignaturaOutputDTO(asignatura));
        }
        EstudianteAsignaturaListaOuput listaOuput= new EstudianteAsignaturaListaOuput();
        listaOuput.setLista(listaOuputDTO);
        return listaOuput;
    }

    @Override
    public void deleteAsignatuas(String id, List<String> id_asignaturas) {
        Estudiante estudiante= estudianterepo.findById(id).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado este registro"));
        for (String id_asignatura:id_asignaturas) {
                Estudiante_Asignatura estudiante_asignatura=  estudianteAsignaturaRepo.findById(id_asignatura).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado este registro"));
                if (estudiante.getId_estudiante().equals(estudiante_asignatura.getEstudiante().getId_estudiante())) {
                    estudianteAsignaturaRepo.delete(estudiante_asignatura);
                }
        }
    }



    private void validarEstudiante(EstudianteinputDTO estudianteinputDTO) throws UnprocesableException{
          if (estudianteinputDTO.getUsuario()==null) throw new UnprocesableException("Error: Usuario no puede ser nulo");
        if (estudianteinputDTO.getUsuario().length()>10 || estudianteinputDTO.getUsuario().length()<6) throw new UnprocesableException("Error: El usuario debe tener entre 6 y 10 caracteres");;
        if (estudianteinputDTO.getPassword()==null) throw new UnprocesableException("Error: Se debe introducir una contraseña");
    }

    private void checkEstudiante_Profesor(EstudianteinputDTO estudianteinputDTO) throws UnprocesableException{
        List<Estudiante> estudiantes= estudianterepo.findAll();
        List<Profesor> profesores = profesorRepo.findAll();

        for (Estudiante estudiante:estudiantes){
            if (estudianteinputDTO.getId_persona().equals(estudiante.getPersona().getId_persona())){
                throw new UnprocesableException("No se ha podido realizar la operación");
            }
        }
        for (Profesor profesor:profesores){
            if (estudianteinputDTO.getId_persona().equals(profesor.getPersona().getId_persona())){
                throw new UnprocesableException("No se ha podido realizar la operación");
            }
        }
    }


    private Estudiante convertoEstudiante(EstudianteinputDTO estudianteinputDTO) throws PersonNotFoundException {
           Estudiante estudiante= new Estudiante();
           estudiante.setPersona(personarepo.findById(estudianteinputDTO.getId_persona()).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado la persona")));
           estudiante.setNum_horas_semana(estudianteinputDTO.getNum_horas_semana());
           estudiante.setBranch(estudianteinputDTO.getBranch());
           estudiante.setComentarios(estudianteinputDTO.getComentarios());
           return estudiante;
    }
}
