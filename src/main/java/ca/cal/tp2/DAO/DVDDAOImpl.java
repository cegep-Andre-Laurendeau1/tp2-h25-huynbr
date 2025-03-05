package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.DVD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class DVDDAOImpl implements DVDDAO{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2BryanHuynh.ex1");

    @Override
    public void save(DVD dvd) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(dvd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public DVD findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(DVD.class, id);
    }

    @Override
    public List<DVD> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT d FROM DVD d", DVD.class)
                .getResultList();
    }
}
