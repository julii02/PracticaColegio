
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

@Getter @Setter
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstudiante;
    private String legajo;
    private String nombre;
    private String apellido;
    
    

    public Estudiante() {
    }

    public Estudiante(long idEstudiante, String legajo, String nombre, String apellido) {
        this.idEstudiante = idEstudiante;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
}
