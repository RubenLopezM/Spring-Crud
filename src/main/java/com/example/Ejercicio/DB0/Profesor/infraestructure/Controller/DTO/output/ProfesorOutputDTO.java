package com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.output;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import lombok.Data;

@Data
public class ProfesorOutputDTO {
    private String id_profesor;
    private String comentarios;
    private String branch;


    public ProfesorOutputDTO(Profesor profesor){
        setId_profesor(profesor.getId_profesor());
        setComentarios(profesor.getComentarios());
        setBranch(profesor.getBranch());

    }
}
