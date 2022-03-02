package com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller;

import com.example.Ejercicio.DB0.Estudiante.application.EstudianteService;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.input.EstudianteinputDTO;
import com.example.Ejercicio.DB0.Estudiante.infrastructure.Controller.DTO.output.EstudianteOutputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.input.EstudianteAsignaturaInputDTO;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaListaOuput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class PostEstudianteController {

    @Autowired
    EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<EstudianteOutputDTO> addEstudiante(@RequestBody EstudianteinputDTO estudianteinputDTO) throws Exception{
        return new ResponseEntity<EstudianteOutputDTO>(estudianteService.addEstudiante(estudianteinputDTO), HttpStatus.CREATED) ;

    }

    @PostMapping("/{id}/asignatura")
    public ResponseEntity<EstudianteAsignaturaListaOuput> addAsignaturas(@PathVariable String id, @RequestBody List<EstudianteAsignaturaInputDTO> list) throws Exception{
         return new ResponseEntity<EstudianteAsignaturaListaOuput>(estudianteService.addAsignaturas(id,list),HttpStatus.OK);
    }
}
