
package com.Colegio.colegio.service;

import com.Colegio.colegio.model.Curso;
import com.Colegio.colegio.repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepo;
    
    @Override
    public List<Curso> traerCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public void guardarCurso(Curso curso) {
       cursoRepo.save(curso);
    }

    @Override
    public Curso cursoConMasEstudiantes() {
        List <Curso> listaCursos = this.traerCursos();
        int maximo = 0;
        Curso cursoMayor = null;
        
        for(Curso curso : listaCursos){
            if(curso.getCantidadEstudiantes() > maximo){
                maximo = curso.getCantidadEstudiantes();
                cursoMayor = curso;
            }
        }
        return cursoMayor;
    }

    @Override
    public List<Curso> cursosConEspacio() {
        List<Curso> cursosEspacios = this.traerCursos();
        List<Curso> cursosConEspacio = new ArrayList<>();
    
    for (Curso curso : cursosEspacios) {
        if (curso.getCantidadEstudiantes() < curso.getCapacidadMaxima()) {
            cursosConEspacio.add(curso);  // Agregar a la nueva lista
        }
    }
    return cursosConEspacio;  // Retornar la nueva lista

    }

    @Override
    public Curso editarCurso(Curso curso) {
        return cursoRepo.save(curso);
    }

    @Override
    public void eliminarCurso(long id) {
        cursoRepo.deleteById(id);
    }
    
}
