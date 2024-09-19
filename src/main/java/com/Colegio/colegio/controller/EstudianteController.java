
package com.Colegio.colegio.controller;

import com.Colegio.colegio.model.Estudiante;
import com.Colegio.colegio.service.IEstudianteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudianteController {
    @Autowired
    private IEstudianteService estudianteServ;
    
    @PostMapping("estudiante/guardar")
    public String guradarEstudiante(@RequestBody Estudiante estudiante){
        estudianteServ.guardarEstudiante(estudiante);
        return "Estudiante guardado correctamente";
    }
    
    @GetMapping("estudiante/traer")
    public List <Estudiante> traerEstudiantes(){
        return estudianteServ.traerEstudiantes();
    }
    
    @PutMapping("/estudiante/editar")
    public Estudiante editarEstudiante(@RequestBody Estudiante estudiante){
        return estudianteServ.editarEstudiante(estudiante);
    }
    
    @DeleteMapping("/estudiante/eliminar/{idEstudiante}")
    public String eliminarEstudiante(@PathVariable long idEstudiante){
        estudianteServ.eliminarEstudiante(idEstudiante);
        return "Eliminado correctamente";
    }
    
}
