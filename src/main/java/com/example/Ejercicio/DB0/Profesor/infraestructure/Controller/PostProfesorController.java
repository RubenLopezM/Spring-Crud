package com.example.Ejercicio.DB0.Profesor.infraestructure.Controller;

import com.example.Ejercicio.DB0.Estudiante.application.EstudianteService;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.Profesor.application.ProfesorService;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.input.ProfesorInputDTO;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("profesor")
@RestController
public class PostProfesorController {
    @Autowired
    ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<ProfesorOutputDTO> addProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) throws Exception{
        return new ResponseEntity<ProfesorOutputDTO>(profesorService.addProfesor(profesorInputDTO), HttpStatus.CREATED) ;

    }
}
