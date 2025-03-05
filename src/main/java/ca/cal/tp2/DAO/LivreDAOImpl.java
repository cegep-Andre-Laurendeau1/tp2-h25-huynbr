package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LivreDAOImpl implements LivreDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2BryanHuynh.ex1");

    @Override
    public void save(Livre livre) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(livre);
            em.getTransaction().commit();
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Livre findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Livre.class, id);
    }

    @Override
    public List<Livre> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT l FROM Livre l", Livre.class)
                .getResultList();
    }
}
