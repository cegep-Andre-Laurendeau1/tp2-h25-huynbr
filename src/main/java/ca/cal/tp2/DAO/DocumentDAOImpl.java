package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class DocumentDAOImpl implements DocumentDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2BryanHuynh.ex1");

    @Override
    public Document findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Document.class, id);
    }

    @Override
    public void save(Document document) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(document);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Document> searchBytitre(String titre) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT d FROM Document d WHERE d.titre LIKE :titre", Document.class)
                .setParameter("titre", "%" + titre + "%")
                .getResultList();
    }

    @Override
    public List<Document> findByAuteur(String auteur) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT d FROM Document d WHERE d.auteur = :auteur", Document.class)
                .setParameter("auteur", auteur)
                .getResultList();
    }

    @Override
    public List<Document> findByYear(int annee) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT d FROM Document d WHERE d.annee = :annee", Document.class)
                .setParameter("annee", annee)
                .getResultList();
    }

    @Override
    public void updateDocument(Document document) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(document);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }


}
