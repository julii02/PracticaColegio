
package com.Colegio.colegio.service;

import com.Colegio.colegio.model.Estudiante;
import com.Colegio.colegio.repository.IEstudianteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private IEstudianteRepository estudianteRepo;
    
    @Override
    public List<Estudiante> traerEstudiantes() {
        return estudianteRepo.findAll();
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        estudianteRepo.save(estudiante);
    }

    @Override
    public Estudiante editarEstudiante(Estudiante estudiante) {
        return estudianteRepo.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(long id) {
        estudianteRepo.deleteById(id);
    }
    
}
