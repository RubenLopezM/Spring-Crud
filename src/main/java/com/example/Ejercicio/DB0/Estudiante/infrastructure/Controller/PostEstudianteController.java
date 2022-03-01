package com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller;

import com.example.Ejercicio.DB0.Estudiante.application.EstudianteService;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiante")
public class PostEstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<EstudianteOutputDTO> addEstudiante(@RequestBody EstudianteinputDTO estudianteinputDTO) throws Exception{
        return new ResponseEntity<EstudianteOutputDTO>(estudianteService.addEstudiante(estudianteinputDTO), HttpStatus.CREATED) ;

    }
}
