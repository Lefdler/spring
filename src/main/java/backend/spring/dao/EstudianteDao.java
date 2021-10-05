package backend.spring.dao;

import backend.spring.models.Estudiante;

import java.util.List;

public interface EstudianteDao {

    List<Estudiante> getEstudiantes();

    void eliminar(Long id);
}
