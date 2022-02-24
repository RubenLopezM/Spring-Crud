package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller;


import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public PersonaoutputDTO getpersonByid(@PathVariable Integer id) throws Exception{
         return personaService.findPersonaid(id);
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
