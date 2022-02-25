package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller;


import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {


    @Autowired
    PersonaService personaService;


    @PostMapping
    public ResponseEntity<PersonaoutputDTO>  addPerson(@RequestBody PersonainputDTO personainputDTO) throws Exception{
        return new ResponseEntity<PersonaoutputDTO>(personaService.addPerson(personainputDTO), HttpStatus.CREATED) ;

    }
}
