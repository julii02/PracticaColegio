
package com.Colegio.colegio.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
//entidad que representa la inscripcion de un alumno a un curso
@Getter @Setter
@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInscripcion;
    
    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    public Inscripcion() {
    }

    public Inscripcion(long idInscripcion, Estudiante estudiante, Curso curso) {
        this.idInscripcion = idInscripcion;
        this.estudiante = estudiante;
        this.curso = curso;
    }
    
    
}
