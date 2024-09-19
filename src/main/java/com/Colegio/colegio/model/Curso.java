package com.Colegio.colegio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCurso;
    private String nombre;
    private int cantidadEstudiantes;
    private int capacidadMaxima;

    public Curso() {
    }

    public Curso(long idCurso, String nombre, int cantidadEstudiantes, int capacidadMaxima) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.cantidadEstudiantes = cantidadEstudiantes;
        this.capacidadMaxima = capacidadMaxima;
    }   
}
