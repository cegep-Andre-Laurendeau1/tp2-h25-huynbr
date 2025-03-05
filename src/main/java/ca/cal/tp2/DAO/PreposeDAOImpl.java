package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Prepose;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PreposeDAOImpl implements PreposeDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2BryanHuynh.ex1");

    @Override
    public void save(Prepose prepose) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(prepose);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Prepose findById(Long id) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Prepose prepose = em.find(Prepose.class, id);
            em.getTransaction().commit();
            return prepose;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Prepose> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Prepose", Prepose.class).getResultList();
    }
}
