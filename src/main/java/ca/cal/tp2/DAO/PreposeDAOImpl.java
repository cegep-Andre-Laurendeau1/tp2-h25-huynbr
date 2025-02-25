package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Prepose;
import jakarta.persistence.EntityManager;

import java.util.List;

public class PreposeDAOImpl implements PreposeDAO {
    private EntityManager entityManager;

    public PreposeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Prepose prepose) {
        entityManager.getTransaction().begin();
        if (prepose.getId() == null) {
            entityManager.persist(prepose);
        } else {
            entityManager.merge(prepose);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Prepose findById(Long id) {
        return null;
    }

    @Override
    public List<Prepose> findAll() {
        return List.of();
    }
}
