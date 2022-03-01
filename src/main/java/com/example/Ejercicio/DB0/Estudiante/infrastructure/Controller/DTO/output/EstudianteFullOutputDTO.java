package com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EstudianteFullOutputDTO extends EstudianteOutputDTO implements Serializable {
    private String id_estudiante;
    private int num_horas_semana;
    private String comentarios;
    private String branch;
    private String usuario;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


    public EstudianteFullOutputDTO (Estudiante estudiante) {
        super(estudiante);
        setUsuario(estudiante.getPersona().getUsuario());
        setName(estudiante.getPersona().getName());
        setSurname(estudiante.getPersona().getSurname());
        setCompany_email(estudiante.getPersona().getCompany_email());
        setPersonal_email(estudiante.getPersona().getPersonal_email());
        setCity(estudiante.getPersona().getCity());
        setActive(estudiante.getPersona().isActive());
        setCreated_date(estudiante.getPersona().getCreated_date());
        setImagen_url(estudiante.getPersona().getImagen_url());
        setTermination_date(estudiante.getPersona().getTermination_date());


    }
}
