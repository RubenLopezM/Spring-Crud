package com.example.Ejercicio.DB0.Profesor.application;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Errores.UnprocesableException;
import com.example.Ejercicio.DB0.Estudiante.application.EstudianteService;
import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Repository.Estudianterepo;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Repository.Personarepo;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.input.ProfesorInputDTO;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.output.ProfesorOutputDTO;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Repository.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServieImp implements ProfesorService {

    @Autowired
    Personarepo personarepo;

    @Autowired
    Estudianterepo estudianterepo;

    @Autowired
    ProfesorRepo profesorRepo;

    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        checkEstudiante_Profesor(profesorInputDTO);
        Profesor profesor = convertoProfesor(profesorInputDTO);
        profesorRepo.save(profesor);

        ProfesorOutputDTO profesorOutputDTO= new ProfesorOutputDTO(profesor);
        return profesorOutputDTO;
    }

    private Profesor convertoProfesor(ProfesorInputDTO profesorInputDTO) throws PersonNotFoundException {
        Profesor profesor= new Profesor();
        profesor.setPersona(personarepo.findById(profesorInputDTO.getId_persona()).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado la persona")));
        profesor.setBranch(profesorInputDTO.getBranch());
        profesor.setComentarios(profesorInputDTO.getComentarios());
        return profesor;
    }

    private void checkEstudiante_Profesor(ProfesorInputDTO profesorInputDTO) throws UnprocesableException{
        List<Estudiante> estudiantes= estudianterepo.findAll();
        List<Profesor> profesores = profesorRepo.findAll();

        for (Estudiante estudiante:estudiantes){
            if (profesorInputDTO.getId_persona().equals(estudiante.getPersona().getId_persona())){
                throw new UnprocesableException("No se ha podido realizar la operación");
            }
        }
        for (Profesor profesor:profesores){
            if (profesorInputDTO.getId_persona().equals(profesor.getPersona().getId_persona())){
                throw new UnprocesableException("No se ha podido realizar la operación");
            }
        }
    }

}
