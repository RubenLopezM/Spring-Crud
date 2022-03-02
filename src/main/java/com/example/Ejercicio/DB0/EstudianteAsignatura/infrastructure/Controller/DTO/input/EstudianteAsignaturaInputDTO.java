package com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.input;

import com.example.Ejercicio.DB0.Estudiante.domain.Estudiante;
import com.example.Ejercicio.DB0.EstudianteAsignatura.domain.Estudiante_Asignatura;
import com.example.Ejercicio.DB0.Profesor.domain.Profesor;
import lombok.Data;

import java.util.Date;

@Data
public class EstudianteAsignaturaInputDTO {
    private String id_estudiante;
    private String id_profesor;
    private String asignatura;
    private String comentarios;
    private Date fechainicio;
    private Date fechafinal;

    public Estudiante_Asignatura convertToEstudianteAsignatura(Estudiante estudiante, Profesor profesor){
        Estudiante_Asignatura estudiante_asignatura= new Estudiante_Asignatura();
        estudiante_asignatura.setEstudiante(estudiante);
        estudiante_asignatura.setProfesor(profesor);
        estudiante_asignatura.setAsignatura(asignatura);
        estudiante_asignatura.setComentarios(comentarios);
        estudiante_asignatura.setFechainicio(fechainicio);
        estudiante_asignatura.setFechafinal(fechafinal);
        return estudiante_asignatura;
    }

}
