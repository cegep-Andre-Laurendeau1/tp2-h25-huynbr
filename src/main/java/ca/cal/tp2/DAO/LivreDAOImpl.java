package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LivreDAOImpl implements LivreDAO {
    EntityManager entityManager;
    public LivreDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(Livre livre) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livre);
            entityManager.getTransaction().commit();
        }catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public Livre findById(Long id) {
        return entityManager.find(Livre.class, id);
    }

    @Override
    public List<Livre> findAll() {
        return entityManager.createQuery("SELECT l FROM Livre l", Livre.class)
                .getResultList();
    }
}
