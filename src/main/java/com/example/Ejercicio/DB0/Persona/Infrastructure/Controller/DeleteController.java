package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    PersonaService personaService;

    @DeleteMapping("persona/{id}")
    public void deletePerson(@PathVariable Integer id) throws PersonNotFoundException {
          personaService.deletePerson(id);
    }
}
