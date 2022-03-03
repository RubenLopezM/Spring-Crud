package com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller;

import com.example.Ejercicio.DB0.EstudianteAsignatura.application.EstudianteAsignaturaService;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaListaOuput;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("estudianteasignatura")
@RestController
public class EstudianteAsignaturaController {

    @Autowired
    EstudianteAsignaturaService estudianteAsignaturaService;

    @PostMapping
    public ResponseEntity<EstudianteAsignaturaOutputDTO> addAsignatura(@RequestBody EstudianteAsignaturaInputDTO inputDTO) throws Exception {
        return new ResponseEntity<EstudianteAsignaturaOutputDTO>(estudianteAsignaturaService.addAsignatura(inputDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteAsignaturaListaOuput>  getAsignaturasEstudiante(@PathVariable String id) throws Exception{
        return new ResponseEntity<EstudianteAsignaturaListaOuput>(estudianteAsignaturaService.findByIDEstudiante(id),HttpStatus.OK);
    }
}
