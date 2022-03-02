package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import lombok.Data;

@Data
public class PersonaStudentDTO extends PersonaoutputDTO{
    private String id_estudiante;
    private int num_horas_semana;
    private String comentarios;
    private String branch;

    public PersonaStudentDTO(Persona persona, Estudiante estudiante){
        super(persona);
        if (estudiante==null){
            return;
        }
        setId_estudiante(estudiante.getId_estudiante());
        setNum_horas_semana(estudiante.getNum_horas_semana());
        setComentarios(estudiante.getComentarios());
        setBranch(estudiante.getBranch());

    }
}
