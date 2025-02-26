package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmprunteurDAOImpl implements EmprunteurDAO {
    private final EntityManager entityManager;

    public EmprunteurDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Emprunteur emprunteur) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(emprunteur);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Emprunteur findById(Long id) {
        return entityManager.find(Emprunteur.class, id);
    }

    @Override
    public List<Emprunt> findByEmprunteur(Emprunteur emprunteur) {
        return entityManager.createQuery("SELECT e FROM Emprunt e WHERE e.emprunteur =:emprunteur", Emprunt.class)
                .setParameter("emprunteur", emprunteur)
                .getResultList();
    }

    @Override
    public void save(Emprunt emprunt) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(emprunt);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }
}
