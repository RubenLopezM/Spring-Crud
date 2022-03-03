package com.example.Ejercicio.DB0.Profesor.application;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.input.ProfesorInputDTO;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.output.ProfesorOutputDTO;

public interface ProfesorService {
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO estudianteinputDTO) throws Exception;
    public ProfesorOutputDTO findProfesor(String id) throws PersonNotFoundException;
}
