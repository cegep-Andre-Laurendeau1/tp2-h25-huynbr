package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Emprunt;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmpruntDAOImpl implements EmpruntDAO {
    EntityManager entityManager;

    public EmpruntDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Emprunt findById(Long id) {
        return entityManager.find(Emprunt.class, id);
    }

    @Override
    public List<Emprunt> findAllByEmpruntId(Long id) {
        return entityManager.createQuery(
                        "SELECT e FROM Emprunt e WHERE e.emprunteur.id = :emprunteurId",
                        Emprunt.class)
                .setParameter("emprunteurId", id)
                .getResultList();
    }

    @Override
    public void save(Emprunt emprunt) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(emprunt);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            } throw e;
        }
    }

    @Override
    public List<Emprunt> findByEmprunteurId(Long id) {
        return entityManager.createQuery(
                        "SELECT e FROM Emprunt e WHERE e.emprunteur.id = :emprunteurId",
                        Emprunt.class)
                .setParameter("emprunteurId", id)
                .getResultList();
    }
}
