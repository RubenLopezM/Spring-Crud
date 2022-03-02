package com.example.Ejercicio.DB0.Estudiante.domain;

import com.example.Ejercicio.DB0.EstudianteAsignatura.domain.Estudiante_Asignatura;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import com.example.Ejercicio.DB0.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiantes_seq")
    @GenericGenerator(
            name = "estudiantes_seq",
            strategy = "com.example.Ejercicio.DB0.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            })
    private String id_estudiante;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", unique = true)
    private Persona persona;
    @Column(nullable = false)
    private int num_horas_semana;
    private String comentarios;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;
    @Column(nullable = false)
    private String branch;

    @OneToMany(mappedBy = "estudiante", cascade = { CascadeType.ALL })
    private List<Estudiante_Asignatura> estudianteAsignaturaList = new ArrayList<>();

}
