package com.example.Ejercicio.DB0.Estudiante.application;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaListaOuput;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;

import java.util.List;

public interface EstudianteService {
    public EstudianteOutputDTO addEstudiante(EstudianteinputDTO estudianteinputDTO) throws Exception;
    public EstudianteOutputDTO findEstudiante(String id, String outputType) throws PersonNotFoundException;
    public EstudianteOutputDTO setEstudiante(EstudianteinputDTO estudianteinputDTO, String id) throws PersonNotFoundException;
    public void deleteEstudiante(String id) throws PersonNotFoundException;
    public EstudianteAsignaturaListaOuput addAsignaturas(String id, List<EstudianteAsignaturaInputDTO> list);
    public void deleteAsignatuas(String id,List<String> list);
}
