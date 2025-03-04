package ca.cal.tp2.Service;

import ca.cal.tp2.DAO.DocumentDAO;
import ca.cal.tp2.DAO.EmpruntDAO;
import ca.cal.tp2.DAO.EmprunteurDAO;
import ca.cal.tp2.modele.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EmpruntService {
    private EmprunteurDAO emprunteurDAO;
    private DocumentDAO documentDAO;
    private EmpruntDAO empruntDAO;
    private EntityManager entityManager;

    public EmpruntService(EmprunteurDAO emprunteurDAO, DocumentDAO documentDAO, EmpruntDAO empruntDAO, EntityManager entityManager) {
        this.emprunteurDAO = emprunteurDAO;
        this.documentDAO = documentDAO;
        this.empruntDAO = empruntDAO;
        this.entityManager = entityManager;
    }
    public void effectuerEmprunt(Long empruntId, String documentTitre) {
        EntityManager em = entityManager;
        EntityTransaction transaction = em.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }
            Emprunteur emprunteur = emprunteurDAO.findById(empruntId);
            List<Document> documents = documentDAO.searchBytitre(documentTitre);

            Optional<Document> documentOpt = documents.stream()
                    .filter(d -> d.getCopiesDisponible() > 0)
                    .findFirst();

            if (!documentOpt.isPresent()) {
                System.out.println("Désolé, plus d'exemplaires disponibles pour: " + documentTitre);
            } else {
                Document document = documentOpt.get();
                if (emprunteur == null) {
                    System.out.println("Emprunteur introuvable.");
                } else {
                    LocalDate date = LocalDate.now().plusDays(getEmpruntDuree(document));
                    Emprunt emprunt = new Emprunt();
                    emprunt.setEmprunteur(emprunteur);
                    emprunt.setDateEmprunt(LocalDate.now());
                    emprunt.setDateRetourPrevu(date);
                    EmpruntDocument empruntDocument = new EmpruntDocument();
                    empruntDocument.setDocument(document);
                    empruntDocument.setEmprunt(emprunt);
                    empruntDocument.setDateRetour(date);
                    emprunt.addEmpruntDocument(empruntDocument);
                    document.setCopiesDisponible(document.getCopiesDisponible() - 1);
                    em.persist(emprunt);
                    em.merge(document);
                    transaction.commit();
                    System.out.println("Emprunt confirmé avec succès pour: " + documentTitre);
                }
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    private int getEmpruntDuree(Document document) {
        if (document instanceof Livre) {
            return 21;
        } else if (document instanceof CD) {
            return 14;
        } else if (document instanceof DVD) {
            return 7;
        }
        return 0;
    }
}
