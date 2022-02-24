package com.example.Ejercicio.DB0.Persona.Infrastructure.Repository;

import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Personarepo extends JpaRepository<Persona,Integer> {

    @Query("select u from Persona u where u.usuario= :usuario")
    List<PersonaoutputDTO> buscaPorNombre(@Param("usuario") String usuario);

}

