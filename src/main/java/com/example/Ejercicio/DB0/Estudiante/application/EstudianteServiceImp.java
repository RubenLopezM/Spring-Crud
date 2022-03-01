package com.example.Ejercicio.DB0.Estudiante.application;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Errores.UnprocesableException;
import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteFullOutputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Repository.Estudianterepo;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Repository.Personarepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImp implements EstudianteService {

    @Autowired
    Personarepo personarepo;

    @Autowired
    Estudianterepo estudianterepo;


    public EstudianteOutputDTO addEstudiante(EstudianteinputDTO estudianteinputDTO){

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

    private void validarEstudiante(EstudianteinputDTO estudianteinputDTO) throws UnprocesableException{
          if (estudianteinputDTO.getUsuario()==null) throw new UnprocesableException("Error: Usuario no puede ser nulo");
        if (estudianteinputDTO.getUsuario().length()>10 || estudianteinputDTO.getUsuario().length()<6) throw new UnprocesableException("Error: El usuario debe tener entre 6 y 10 caracteres");;
        if (estudianteinputDTO.getPassword()==null) throw new UnprocesableException("Error: Se debe introducir una contraseña");
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
