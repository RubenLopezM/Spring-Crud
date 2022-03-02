package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
public class PersonaListOutputDTO implements Serializable {
   private List<PersonaoutputDTO> lista;
}
