package com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Estudiante.application.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("estudiante")
@RestController
public class DeleteEstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) throws PersonNotFoundException {
        estudianteService.deleteEstudiante(id);
    }
}
