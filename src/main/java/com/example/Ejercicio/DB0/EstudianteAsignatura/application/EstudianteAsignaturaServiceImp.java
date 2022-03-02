package com.example.Ejercicio.DB0.EstudianteAsignatura.application;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Repository.Estudianterepo;
import com.example.Ejercicio.DB0.EstudianteAsignatura.domain.Estudiante_Asignatura;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaListaOuput;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaOutputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Repository.EstudianteAsignaturaRepo;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Repository.ProfesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteAsignaturaServiceImp implements EstudianteAsignaturaService {

    @Autowired
    Estudianterepo estudianteRepo;

    @Autowired
    ProfesorRepo profesorRepo;

    @Autowired
    EstudianteAsignaturaRepo estudianteAsignaturaRepo;

    @Override
    public EstudianteAsignaturaOutputDTO addAsignatura(EstudianteAsignaturaInputDTO inputDTO) throws PersonNotFoundException {
        Estudiante estudiante = estudianteRepo.findById(inputDTO.getId_estudiante()).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado este registro"));

        Profesor profesor = profesorRepo.findById(inputDTO.getId_profesor())
                .orElseThrow(()->new PersonNotFoundException("No se ha encontrado este registro"));

        Estudiante_Asignatura estudianteAsignatura = inputDTO.convertToEstudianteAsignatura(estudiante,profesor);
        estudianteAsignaturaRepo.save(estudianteAsignatura);
        return new EstudianteAsignaturaOutputDTO(estudianteAsignatura);
    }

    @Override
    public EstudianteAsignaturaListaOuput findByIDEstudiante(String id) throws PersonNotFoundException {
        List<EstudianteAsignaturaOutputDTO> estudianteAsignaturaOutputDTOList = new ArrayList<>();
        Estudiante estudiante = estudianteRepo.findById(id).orElseThrow(()-> new PersonNotFoundException("No se ha encontrado este registro"));
        List<Estudiante_Asignatura> list= estudiante.getEstudianteAsignaturaList();
        list.forEach((e)-> estudianteAsignaturaOutputDTOList.add(new EstudianteAsignaturaOutputDTO(e)));

          EstudianteAsignaturaListaOuput listaOuput= new EstudianteAsignaturaListaOuput();
          listaOuput.setLista(estudianteAsignaturaOutputDTOList);
        return listaOuput;
    }


}
