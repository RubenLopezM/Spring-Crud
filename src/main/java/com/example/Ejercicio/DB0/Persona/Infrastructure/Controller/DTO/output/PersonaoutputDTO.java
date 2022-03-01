package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output;


import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaoutputDTO implements Serializable {

    private String id_persona;
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

    public PersonaoutputDTO(Persona persona){
        if (persona==null){
            return;
        }
        setId_persona(persona.getId_persona());
        setUsuario(persona.getUsuario());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());
    }

}
