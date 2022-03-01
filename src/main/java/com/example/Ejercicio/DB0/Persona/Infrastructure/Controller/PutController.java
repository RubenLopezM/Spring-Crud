package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller;

import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutController {

    @Autowired
    PersonaService personaService;

    @PutMapping("/persona/{id}")
    public ResponseEntity <PersonaoutputDTO> updatePerson(@PathVariable String id, @RequestBody PersonainputDTO personainputDTO) throws Exception{
                return new ResponseEntity<PersonaoutputDTO>(personaService.setPerson(personainputDTO,id), HttpStatus.OK);
    }
}
