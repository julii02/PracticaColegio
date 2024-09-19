
package com.Colegio.colegio.service;

import com.Colegio.colegio.model.Curso;
import com.Colegio.colegio.model.Estudiante;
import com.Colegio.colegio.model.Inscripcion;
import com.Colegio.colegio.repository.ICursoRepository;
import com.Colegio.colegio.repository.IInscripcionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService implements IInscripcionService {

    @Autowired
    private IInscripcionRepository inscriRepo;
    
    @Autowired ICursoRepository cursoRepo;
    
    @Override
    public List<Inscripcion> traerInscripciones() {
        return inscriRepo.findAll();
    }

    @Override
    public void guardarInscripcion(Inscripcion inscripcion) {
        long idCurso = inscripcion.getCurso().getIdCurso();
        
        Curso curso = cursoRepo.findById(idCurso).orElse(null);
        
        if(curso != null){
            if(curso.getCantidadEstudiantes() < curso.getCapacidadMaxima()){
                curso.setCantidadEstudiantes(curso.getCantidadEstudiantes()+1);
                cursoRepo.save(curso);
                inscriRepo.save(inscripcion);
            }
            else{
                throw new UnsupportedOperationException("NO HAY MAS CAPACIDAD EN ESTE CURSO");
            }
        }
        else{
            throw new UnsupportedOperationException("CURSO NO EXISTENTE!!!");
        }
    }

    @Override
    public List<Estudiante> traerEstudiantePorCurso(long idCurso) {
        List <Estudiante> listaEstudiantes = new ArrayList<>();
        List <Inscripcion> listaInscripciones= this.traerInscripciones();
        
        for(Inscripcion inscri : listaInscripciones){
            if(inscri.getCurso().getIdCurso() == idCurso){
                listaEstudiantes.add(inscri.getEstudiante());
            }
        }
        if(listaEstudiantes != null){
            return listaEstudiantes;
        }
        else{
            return null;
        }
    }

    @Override
    public void eliminarInscripcion(long id) {
        Inscripcion inscri = inscriRepo.findById(id).orElse(null);
        Curso curso = inscri.getCurso();
        curso.setCantidadEstudiantes(curso.getCantidadEstudiantes() - 1);
        cursoRepo.save(curso);
        
        inscriRepo.deleteById(id);
    }

    @Override
    public List<Inscripcion> inscripcionesPorEstudiante(String nombre) {
        List <Inscripcion> todasInscripciones = this.traerInscripciones();
        
        List <Inscripcion> inscripcionesFiltradas = new ArrayList<>();
        
        for(Inscripcion inscripcion : todasInscripciones){
            if(inscripcion.getEstudiante().getNombre().contains(nombre) || inscripcion.getEstudiante().getApellido().contains(nombre)){
                inscripcionesFiltradas.add(inscripcion);
            }
        }
        return inscripcionesFiltradas;
    }
    
}
