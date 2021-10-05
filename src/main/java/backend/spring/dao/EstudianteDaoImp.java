package backend.spring.dao;

import backend.spring.models.Estudiante;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class EstudianteDaoImp implements EstudianteDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Estudiante> getEstudiantes() {
        String query = "FROM Estudiante";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Estudiante estudiante = entityManager.find(Estudiante.class ,id);
        entityManager.remove(estudiante);
    }

}
