package com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.output;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorOutputDTO  {
    private String id_profesor;
    private String comentarios;
    private String branch;


    public ProfesorOutputDTO(Profesor profesor){

        setId_profesor(profesor.getId_profesor());
        setComentarios(profesor.getComentarios());
        setBranch(profesor.getBranch());

    }
}
