package com.example.Ejercicio.DB0.Profesor.infraestructure.Controller;

import com.example.Ejercicio.DB0.Profesor.application.ProfesorService;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/profesor")
@RestController
public class GetProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorOutputDTO> getProfesorbyID(@PathVariable String id){
        return new  ResponseEntity<ProfesorOutputDTO> (profesorService.findProfesor(id), HttpStatus.OK);

    }
}
