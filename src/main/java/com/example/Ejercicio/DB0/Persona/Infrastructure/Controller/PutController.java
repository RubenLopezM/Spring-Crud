package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller;

import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutController {

    @Autowired
    PersonaService personaService;

    @PutMapping("/persona/{id}")
    public PersonaoutputDTO updatePerson(@PathVariable Integer id, @RequestBody PersonainputDTO personainputDTO) throws Exception{
                return personaService.setPerson(personainputDTO,id);
    }
}
