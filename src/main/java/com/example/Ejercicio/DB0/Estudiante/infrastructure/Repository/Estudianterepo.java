package com.example.Ejercicio.DB0.Estudiante.infrastructure.Repository;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Estudianterepo extends JpaRepository<Estudiante, String> {
}
