package com.example.Ejercicio.DB0.EstudianteAsignatura.domain;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Estudiante_Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignatura_seq")
    @GenericGenerator(
            name = "asignatura_seq",
            strategy = "com.example.Ejercicio.DB0.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            })
    private String id_asignatura;
    @JoinColumn(name = "id_estudiante")
    @ManyToOne
    private Estudiante estudiante;
    private String asignatura;
    private String comentarios;
    @Column(nullable = false)
    private Date fecha_inicio;
    private Date fechafinal;
}
