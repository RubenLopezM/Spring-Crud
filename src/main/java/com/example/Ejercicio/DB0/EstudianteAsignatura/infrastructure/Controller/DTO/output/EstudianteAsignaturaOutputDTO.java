package com.example.Ejercicio.DB0.EstudianteAsignatura.infrastructure.Controller.DTO.output;

import com.example.Ejercicio.DB0.EstudianteAsignatura.domain.Estudiante_Asignatura;
import lombok.Data;

import java.util.Date;

@Data
public class EstudianteAsignaturaOutputDTO {
    private String id_asignatura;
    private String id_estudiante;
    private String id_profesor;
    private String asignatura;
    private String comentarios;
    private Date fechainicio;
    private Date fechafinal;

    public EstudianteAsignaturaOutputDTO(Estudiante_Asignatura estudiante_asignatura){
       this.id_asignatura= estudiante_asignatura.getId_asignatura();
       this.id_estudiante= estudiante_asignatura.getEstudiante().getId_estudiante();
       this.id_profesor= estudiante_asignatura.getProfesor().getId_profesor();
       this.asignatura= estudiante_asignatura.getAsignatura();
       this.comentarios= estudiante_asignatura.getComentarios();
       this.fechainicio=estudiante_asignatura.getFechainicio();
       this.fechafinal= estudiante_asignatura.getFechafinal();
    }
}
