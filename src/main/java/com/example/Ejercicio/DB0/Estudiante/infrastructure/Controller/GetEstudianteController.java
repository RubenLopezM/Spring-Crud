package com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller;

import com.example.Ejercicio.DB0.Estudiante.application.EstudianteService;
import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteFullOutputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estudiante")
public class GetEstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("{id}")
    public ResponseEntity<EstudianteOutputDTO> getEstudiante(@PathVariable String id, @RequestParam(required = false, defaultValue = "simple") String outputType) throws Exception {
        EstudianteOutputDTO estudiante= (estudianteService.findEstudiante(id, outputType));

        return new ResponseEntity<EstudianteOutputDTO>(estudiante,HttpStatus.OK);
    }

}
