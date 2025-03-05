package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.CD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CDDAOImpl implements CDDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2BryanHuynh.ex1");

    @Override
    public void save(CD cd) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(cd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CD findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(CD.class, id);
    }

    @Override
    public List<CD> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT c FROM CD c", CD.class)
                .getResultList();
    }
}
