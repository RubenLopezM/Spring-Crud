package com.example.Ejercicio.DB0.Persona.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Entity(name = "Persona")
@Data
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Integer id_persona;
    @Column(nullable = false)
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
}
