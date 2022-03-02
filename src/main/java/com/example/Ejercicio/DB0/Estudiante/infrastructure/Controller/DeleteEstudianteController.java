package com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Estudiante.application.EstudianteService;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.input.EstudianteAsignaturaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("estudiante")
@RestController
public class DeleteEstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) throws PersonNotFoundException {
        estudianteService.deleteEstudiante(id);
    }

    @DeleteMapping("/{id}/asignatura")
    public void deleteAsignaturas(@PathVariable String id, @RequestBody List<String> listaids) throws PersonNotFoundException {
        estudianteService.deleteAsignatuas(id,listaids);
    }
}
