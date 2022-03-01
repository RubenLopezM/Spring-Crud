package com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller;

import com.example.Ejercicio.DB0.Estudiante.application.EstudianteService;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("estudiante")
@RestController
public class PutEstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteOutputDTO> updateEstudiante(@PathVariable String id, @RequestBody EstudianteinputDTO personainputDTO) throws Exception{
        EstudianteOutputDTO estudiante= estudianteService.setEstudiante(personainputDTO, id);
        return new ResponseEntity<EstudianteOutputDTO>( estudiante, HttpStatus.OK);
    }
}
