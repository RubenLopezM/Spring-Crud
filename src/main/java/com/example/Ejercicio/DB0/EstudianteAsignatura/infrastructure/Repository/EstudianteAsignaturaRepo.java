package com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Repository;

import com.example.Ejercicio.DB0.EstudianteAsignatura.domain.Estudiante_Asignatura;
import com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output.EstudianteAsignaturaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudianteAsignaturaRepo extends JpaRepository<Estudiante_Asignatura,String> {


}
