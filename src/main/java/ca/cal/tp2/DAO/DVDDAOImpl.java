package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DVDDAOImpl implements DVDDAO{
    EntityManager entityManager;
    public DVDDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(DVD dvd) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(dvd);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public DVD findById(Long id) {
        return entityManager.find(DVD.class, id);
    }

    @Override
    public List<DVD> findAll() {
        return entityManager.createQuery("SELECT d FROM DVD d", DVD.class)
                .getResultList();
    }
}
