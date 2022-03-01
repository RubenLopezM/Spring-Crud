package com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class EstudianteinputDTO extends PersonainputDTO implements Serializable {
    private String id_estudiante;
    private String id_persona;
    private int num_horas_semana;
    private String comentarios;
    private String branch;

    public EstudianteinputDTO  (Persona persona){
        if (persona==null){
            return;
        }

        setBranch(branch);
        setNum_horas_semana(num_horas_semana);
        setComentarios(comentarios);

    }
}
