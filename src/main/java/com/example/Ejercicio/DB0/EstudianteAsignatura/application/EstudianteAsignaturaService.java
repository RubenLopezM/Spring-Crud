package com.example.Ejercicio.DB0.EstudianteAsignatura.application;

import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaListaOuput;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaOutputDTO;

public interface EstudianteAsignaturaService {
    EstudianteAsignaturaOutputDTO addAsignatura(EstudianteAsignaturaInputDTO inputDTO) throws Exception;
    EstudianteAsignaturaListaOuput findByIDEstudiante(String id) throws Exception;
}
