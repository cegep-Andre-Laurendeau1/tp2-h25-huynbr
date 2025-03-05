package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmpruntDAOImpl implements EmpruntDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2BryanHuynh.ex1");

    @Override
    public Emprunt findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Emprunt.class, id);
    }

    @Override
    public List<Emprunt> findAllByEmpruntId(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                        "SELECT e FROM Emprunt e WHERE e.emprunteur.id = :emprunteurId",
                        Emprunt.class)
                .setParameter("emprunteurId", id)
                .getResultList();
    }

    @Override
    public void save(Emprunt emprunt) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(emprunt);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Emprunt> findByEmprunteurId(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
                        "SELECT e FROM Emprunt e WHERE e.emprunteur.id = :emprunteurId",
                        Emprunt.class)
                .setParameter("emprunteurId", id)
                .getResultList();
    }
}
