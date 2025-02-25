package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.CD;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CDDAOImpl implements CDDAO {
    EntityManager entityManager;
    public CDDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(CD cd) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cd);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public CD findById(Long id) {
        return entityManager.find(CD.class, id);
    }

    @Override
    public List<CD> findAll() {
        return entityManager.createQuery("SELECT c FROM CD c", CD.class)
                .getResultList();
    }
}
