package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller;


import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetController {

    @Autowired
    PersonaService personaService;

    @GetMapping("{id}")
    public ResponseEntity<PersonaoutputDTO> getpersonByid(@PathVariable Integer id) throws PersonNotFoundException {
         return new ResponseEntity<PersonaoutputDTO>(personaService.findPersonaid(id),HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuario}")
    public List <PersonaoutputDTO> getpersonusuario(@PathVariable String usuario) throws Exception{
           return personaService.findUsuario(usuario);
    }

    @GetMapping
    public List <PersonaoutputDTO> getAllpersons(){
       return personaService.getUsuarios();
    }
}
