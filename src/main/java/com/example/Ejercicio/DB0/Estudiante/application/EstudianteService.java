package com.example.Ejercicio.DB0.Estudiante.application;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Errores.UnprocesableException;
import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;

public interface EstudianteService {
    public EstudianteOutputDTO addEstudiante(EstudianteinputDTO estudianteinputDTO) throws Exception;
    public EstudianteOutputDTO findEstudiante(String id, String outputType) throws PersonNotFoundException;
    public EstudianteOutputDTO setEstudiante(EstudianteinputDTO estudianteinputDTO, String id) throws PersonNotFoundException;
    public void deleteEstudiante(String id) throws PersonNotFoundException;
}
