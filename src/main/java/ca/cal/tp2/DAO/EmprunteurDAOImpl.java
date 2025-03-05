package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmprunteurDAOImpl implements EmprunteurDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2BryanHuynh.ex1");

    @Override
    public void save(Emprunteur emprunteur) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(emprunteur);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Emprunteur findById(Long id) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Emprunteur emprunteur = em.find(Emprunteur.class, id);
            em.getTransaction().commit();
            return emprunteur;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Emprunt> findByEmprunteur(Emprunteur emprunteur) {
        try (EntityManager em = emf.createEntityManager()){
            return em.createQuery("SELECT e FROM Emprunt e WHERE e.emprunteur =:emprunteur", Emprunt.class)
                    .setParameter("emprunteur", emprunteur)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Emprunt emprunt) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(emprunt);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
