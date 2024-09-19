
package com.Colegio.colegio.service;

import com.Colegio.colegio.model.Estudiante;
import com.Colegio.colegio.model.Inscripcion;
import java.util.List;

public interface IInscripcionService {
    
    public List <Inscripcion> traerInscripciones();
    
    public void guardarInscripcion(Inscripcion inscripcion);
    
    public List <Estudiante> traerEstudiantePorCurso(long idCurso);
    
    public void eliminarInscripcion(long id);
    
    public List <Inscripcion> inscripcionesPorEstudiante(String nombre);
}
