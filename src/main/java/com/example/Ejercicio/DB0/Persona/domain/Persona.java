package com.example.Ejercicio.DB0.Persona.domain;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import com.example.Ejercicio.DB0.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

import java.util.Date;

@Entity(name = "Persona")
@Data
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personas_seq")
    @GenericGenerator(
            name = "personas_seq",
            strategy = "com.example.Ejercicio.DB0.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            })

    @Column(name = "id_persona",updatable = false)
    private String id_persona;
    @Column(nullable = false, unique = true)
    private String usuario;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    private String surname;
    @Column(nullable = false)
    private String company_email;
    @Column(nullable = false)
    private String personal_email;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = false)
    private Date created_date;
    private String imagen_url;
    private Date termination_date;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Estudiante estudiante;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Profesor profesor;
    @Column(nullable = false)
    private boolean admin;


}
