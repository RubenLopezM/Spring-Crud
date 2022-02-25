package com.example.Ejercicio.DB0.Persona.application;

import com.example.Ejercicio.DB0.Errores.PersonNotFoundException;
import com.example.Ejercicio.DB0.Errores.UnprocesableException;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;

import java.util.List;

public interface PersonaService {
  public PersonaoutputDTO addPerson(PersonainputDTO persona) throws Exception;
  public PersonaoutputDTO findPersonaid(Integer id) throws PersonNotFoundException;
  public List <PersonaoutputDTO> findUsuario(String usuario);
  public List <PersonaoutputDTO> getUsuarios();
  public PersonaoutputDTO setPerson(PersonainputDTO personainputDTO, Integer id) throws UnprocesableException,PersonNotFoundException;
  public void deletePerson(Integer id) throws PersonNotFoundException;
}
