package com.example.Ejercicio.DB0.Persona.Infrastructure.Repository;

import com.example.Ejercicio.DB0.Persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface Personarepo extends JpaRepository<Persona,String> {

    List<Persona> findByUsuario(String usuario);

}

