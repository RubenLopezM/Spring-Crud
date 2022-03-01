package com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EstudianteOutputDTO  implements Serializable {
    private String id_estudiante;
    private int num_horas_semana;
    private String comentarios;
    private String branch;


    public EstudianteOutputDTO(Estudiante estudiante){
        setId_estudiante(estudiante.getId_estudiante());
        setNum_horas_semana(estudiante.getNum_horas_semana());
        setComentarios(estudiante.getComentarios());
        setBranch(estudiante.getBranch());

    }
}
