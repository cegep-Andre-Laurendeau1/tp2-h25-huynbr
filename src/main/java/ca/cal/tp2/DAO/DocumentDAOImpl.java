package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Document;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DocumentDAOImpl implements DocumentDAO {
    private EntityManager entityManager;

    public DocumentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Document findById(Long id) {
        return entityManager.find(Document.class, id);
    }

    @Override
    public void save(Document document) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(document);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Document> searchBytitre(String titre) {
        return entityManager.createQuery("SELECT d FROM Document d WHERE d.titre LIKE :titre", Document.class)
                .setParameter("titre", "%" + titre + "%")
                .getResultList();
    }

    @Override
    public List<Document> findByAuteur(String auteur) {
        return List.of();
    }

    @Override
    public List<Document> findByYear(int annee) {
        return List.of();
    }

    @Override
    public List<Document> findByEditeur(String editeur) {
        return List.of();
    }
}
