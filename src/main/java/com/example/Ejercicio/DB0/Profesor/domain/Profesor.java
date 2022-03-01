package com.example.Ejercicio.DB0.Profesor.domain;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import com.example.Ejercicio.DB0.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesores_seq")
    @GenericGenerator(
            name = "profesores_seq",
            strategy = "com.example.Ejercicio.DB0.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            })
    private String id_profesor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona persona;
    private String comentarios;
    @Column(nullable = false)
    private String branch;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudiante> estudiantes;
}
