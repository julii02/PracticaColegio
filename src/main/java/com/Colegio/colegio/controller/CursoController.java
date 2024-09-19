
package com.Colegio.colegio.controller;

import com.Colegio.colegio.model.Curso;
import com.Colegio.colegio.service.ICursoService;
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
public class CursoController {
    @Autowired
    private ICursoService cursoServ;
    
    @PostMapping("/curso/guardar")
    public String guardarCurso(@RequestBody Curso curso){
        cursoServ.guardarCurso(curso);
        return "Curso guardado correctamente";
    }
    
    @GetMapping("/curso/traer")
    public List <Curso> traerCursos(){
       return cursoServ.traerCursos();
    }
    
    @GetMapping("/curso/cursoConMasAlumnos")
    public Curso cursoConMasAlumnos(){
       return cursoServ.cursoConMasEstudiantes();
    }
    
    @GetMapping("/curso/cursoEspacios")
    public List <Curso> cursosConEspacio(){
       return cursoServ.cursosConEspacio();
    }
    
    @PutMapping("/curso/editar")
    public Curso editarCurso(@RequestBody Curso curso){
        return cursoServ.editarCurso(curso);
    }
    
    @DeleteMapping("/curso/eliminar/{idCurso}")
    public String eliminarCurso(@PathVariable long idCurso){
        cursoServ.eliminarCurso(idCurso);
        return "Eliminado correctamente";
    }
}
