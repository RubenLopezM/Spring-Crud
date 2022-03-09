package com.example.Ejercicio.DB0.Profesor.infraestructure.Controller;


import com.example.Ejercicio.DB0.Profesor.application.ProfesorService;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.input.ProfesorInputDTO;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("profesor")
@RestController
public class PutProfesorController {

    @Autowired
    ProfesorService profesorService;

    @PutMapping("{id}")
    public ResponseEntity<ProfesorOutputDTO> updateProfesor(@PathVariable String id,@RequestBody ProfesorInputDTO profesorInputDTO) throws Exception {
        return new ResponseEntity<ProfesorOutputDTO>(profesorService.updateProfesor(id,profesorInputDTO), HttpStatus.ACCEPTED);
    }
}
