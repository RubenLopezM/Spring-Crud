package com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.input;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProfesorInputDTO implements Serializable {
    private String id_persona;
    private String comentarios;
    private String branch;

}
