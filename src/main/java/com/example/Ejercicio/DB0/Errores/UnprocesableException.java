package com.example.Ejercicio.DB0.Errores;

import lombok.Data;


public class UnprocesableException extends RuntimeException {
    public UnprocesableException(String mensaje){
        super(mensaje);
    }
}
