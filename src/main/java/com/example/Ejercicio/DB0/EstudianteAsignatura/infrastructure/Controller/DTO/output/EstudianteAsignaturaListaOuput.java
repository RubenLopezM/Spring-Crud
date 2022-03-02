package com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output;

import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EstudianteAsignaturaListaOuput implements Serializable {
    private List<EstudianteAsignaturaOutputDTO> lista;
}
