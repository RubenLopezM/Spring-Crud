package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input;

import com.example.Ejercicio.DB0.Persona.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
public class PersonainputDTO {


    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;


}
