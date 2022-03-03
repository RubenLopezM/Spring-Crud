package com.example.Ejercicio.DB0;

import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaProfesorDTO;
import com.example.Ejercicio.DB0.Profesor.infraestructure.Controller.DTO.output.ProfesorOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "feign", url = "http://localhost:8081/")
public interface Feign {

    @RequestMapping(method = RequestMethod.GET, value = "profesor/{id}")
    ResponseEntity<ProfesorOutputDTO> getInfoProfesor(@PathVariable String id);
}
