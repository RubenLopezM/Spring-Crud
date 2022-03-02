package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output;

import com.example.Ejercicio.DB0.Persona.domain.Persona;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import lombok.Data;

@Data
public class PersonaProfesorDTO extends PersonaoutputDTO{
    private String id_profesor;
    private String comentarios;
    private String branch;

    public PersonaProfesorDTO(Persona persona, Profesor profesor){
        super(persona);
        if (profesor== null){
            return;
        }
        setId_profesor(profesor.getId_profesor());
        setComentarios(profesor.getComentarios());
        setBranch(profesor.getBranch());
    }
}
