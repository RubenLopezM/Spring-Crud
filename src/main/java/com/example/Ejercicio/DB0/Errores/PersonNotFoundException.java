package com.example.Ejercicio.DB0.Errores;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String mensaje){
        super(mensaje);
    }
}
