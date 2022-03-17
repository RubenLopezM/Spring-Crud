package com.example.Ejercicio.DB0.Persona.application;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Errores.UnprocesableException;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaListOutputDTO;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;

import java.util.List;

public interface PersonaService {
  public PersonaoutputDTO addPerson(PersonainputDTO persona) throws Exception;
  public PersonaoutputDTO findPersonaid(String id, String outputType) throws PersonNotFoundException;
  public PersonaListOutputDTO findUsuario(String usuario, String outputType);
  public PersonaListOutputDTO getUsuarios(String outputType);
  public PersonaoutputDTO setPerson(PersonainputDTO personainputDTO, String id) throws UnprocesableException,PersonNotFoundException;
  public void deletePerson(String id) throws PersonNotFoundException, UnprocesableException;
}
