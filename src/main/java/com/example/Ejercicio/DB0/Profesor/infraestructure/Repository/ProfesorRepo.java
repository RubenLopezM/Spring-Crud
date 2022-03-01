package com.example.Ejercicio.DB0.Profesor.infraestructure.Repository;

import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepo extends JpaRepository<Profesor,String> {
}
