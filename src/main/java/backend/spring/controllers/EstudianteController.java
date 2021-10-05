package backend.spring.controllers;

import backend.spring.dao.EstudianteDao;
import backend.spring.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EstudianteController {

    @Autowired
    private EstudianteDao estudianteDao;

    @RequestMapping(value ="api/estudiantes/{id}", method = RequestMethod.GET)
    public Estudiante getEstudiante(@PathVariable Long id) {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        estudiante.setNombre("Harold");
        estudiante.setApellido("Rojas");
        estudiante.setPromedio("5");
        estudiante.setCarrera("Ingenieria de Sistemas");
        return  estudiante;
    }

    @RequestMapping(value ="api/estudiantes")
    public List<Estudiante> getEstudiantes() {
        return estudianteDao.getEstudiantes();
    }

    @RequestMapping(value ="estudiante1")
    public Estudiante editar() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Harold");
        estudiante.setApellido("Rojas");
        estudiante.setPromedio("5");
        estudiante.setCarrera("Ingenieria de Sistemas");
        return  estudiante;
    }

    @RequestMapping(value ="api/estudiantes/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        estudianteDao.eliminar(id);
    }

    @RequestMapping(value ="estudiante3")
    public Estudiante buscar() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Harold");
        estudiante.setApellido("Rojas");
        estudiante.setPromedio("5");
        estudiante.setCarrera("Ingenieria de Sistemas");
        return  estudiante;
    }
}
