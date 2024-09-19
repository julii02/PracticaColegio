
package com.Colegio.colegio.service;

import com.Colegio.colegio.model.Estudiante;
import java.util.List;


public interface IEstudianteService {
    
    public List <Estudiante> traerEstudiantes();
    
    public void guardarEstudiante(Estudiante estudiante);
    
    public Estudiante editarEstudiante(Estudiante estudiante);
    
    public void eliminarEstudiante(long id);
}
