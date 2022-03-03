package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller;


import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Feign;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaListOutputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaProfesorDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("persona")
@RestController
public class GetController {

    @Autowired
    PersonaService personaService;

    @Autowired
    Feign feign;

    @GetMapping("{id}")
    public ResponseEntity<PersonaoutputDTO> getpersonByid(@PathVariable String id, @RequestParam(required = false, defaultValue = "simple") String outputType) throws PersonNotFoundException {
         return new ResponseEntity<PersonaoutputDTO>(personaService.findPersonaid(id, outputType),HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<PersonaListOutputDTO>  getpersonusuario(@PathVariable String usuario,@RequestParam(name="outputType", required = false, defaultValue = "simple") String outputType) throws Exception{
           return new ResponseEntity<PersonaListOutputDTO>(personaService.findUsuario(usuario,outputType),HttpStatus.OK) ;
    }

    @GetMapping
    public ResponseEntity <PersonaListOutputDTO> getAllpersons(@RequestParam(name="outputType", required = false, defaultValue = "simple") String outputType){
       return new ResponseEntity<PersonaListOutputDTO>(personaService.getUsuarios(outputType),HttpStatus.OK) ;
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<ProfesorOutputDTO> getProfesor(@PathVariable String id){
       // ResponseEntity<ProfesorOutputDTO> rs= new RestTemplate().getForEntity("http://localhost:8081/profesor/"+ id,ProfesorOutputDTO.class);
        //return ResponseEntity.ok(rs.getBody());
        return feign.getInfoProfesor(id);
    }

}
