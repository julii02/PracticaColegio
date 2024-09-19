
package com.Colegio.colegio.service;

import com.Colegio.colegio.model.Curso;
import java.util.List;


public interface ICursoService {
    public List <Curso> traerCursos();
    
    public void guardarCurso(Curso curso);
    
    public Curso cursoConMasEstudiantes();
    
    public List <Curso> cursosConEspacio();
    
    public Curso editarCurso(Curso curso);
    
    public void eliminarCurso(long id);
}
