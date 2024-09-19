
package com.Colegio.colegio.controller;

import com.Colegio.colegio.model.Estudiante;
import com.Colegio.colegio.model.Inscripcion;
import com.Colegio.colegio.service.IInscripcionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InscripcionController {
 
    @Autowired
    private IInscripcionService inscriServ;
    
    @GetMapping("/inscripcion/traer")
    public List <Inscripcion> traerInscripciones(){
        return inscriServ.traerInscripciones();
    }
    
    @PostMapping("/inscripcion/guardar")
    public void guardarInscripcion(@RequestBody Inscripcion inscripcion){
        inscriServ.guardarInscripcion(inscripcion);
    }
    
    @GetMapping("/inscripcion/traer/{idCurso}")
    public List <Estudiante> traerEstudiantePorCurso(@PathVariable long idCurso){
        
        List <Estudiante> listaEstudiantes = inscriServ.traerEstudiantePorCurso(idCurso);
        if(listaEstudiantes != null){
            return listaEstudiantes;
        }
        else{
            return null;
        }
    }
    
    @DeleteMapping("/inscripcion/borrar/{idInscripcion}")
    public String borrarInscripcion(@PathVariable long idInscripcion){
        inscriServ.eliminarInscripcion(idInscripcion);
        return"Inscripcion Eliminida!!!";
    }
    
    @GetMapping("/inscripcion/filtro/{nombre}")
    public List <Inscripcion> inscripcionesPorEstudiante(@PathVariable String nombre){
        return inscriServ.inscripcionesPorEstudiante(nombre);
    }
    
}
