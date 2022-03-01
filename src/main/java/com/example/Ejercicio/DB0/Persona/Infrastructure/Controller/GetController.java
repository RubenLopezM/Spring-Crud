package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller;


import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetController {

    @Autowired
    PersonaService personaService;

    @GetMapping("{id}")
    public ResponseEntity<PersonaoutputDTO> getpersonByid(@PathVariable String id) throws PersonNotFoundException {
         return new ResponseEntity<PersonaoutputDTO>(personaService.findPersonaid(id),HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuario}")
    public List <PersonaoutputDTO> getpersonusuario(@PathVariable String usuario, @RequestParam int page) throws Exception{
           return personaService.findUsuario(usuario, page);
    }

    @GetMapping
    public List <PersonaoutputDTO> getAllpersons(){
       return personaService.getUsuarios();
    }
}
