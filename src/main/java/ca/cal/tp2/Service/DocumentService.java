package ca.cal.tp2.Service;

import ca.cal.tp2.DAO.DocumentDAO;
import ca.cal.tp2.DTO.DocumentDTO;
import ca.cal.tp2.modele.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentService {
    private DocumentDAO documentDAO;
    public DocumentService(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public List<DocumentDTO> chercherParTitre(String titre) {
        List<Document> listeDocuments = documentDAO.searchBytitre(titre);
        List<DocumentDTO> resultat = new ArrayList<>();

        for (Document document : listeDocuments) {
            resultat.add(toDTO(document));
        }
        return resultat;
    }
    public List<DocumentDTO> chercherParAuteur(String auteur) {
        List<Document> listeDocuments = documentDAO.findByAuteur(auteur);
        List<DocumentDTO> resultat = new ArrayList<>();

        for (Document document : listeDocuments) {
            resultat.add(toDTO(document));
        }
        return resultat;
    }

    public List<DocumentDTO> chercherParAnne(int anne) {
        List<Document> listeDocuments = documentDAO.findByYear(anne);
        List<DocumentDTO> resultat = new ArrayList<>();

        for (Document document : listeDocuments) {
            resultat.add(toDTO(document));
        }
        return resultat;
    }

    private DocumentDTO toDTO(Document document) {
        DocumentDTO dto = new DocumentDTO();
        dto.setId(document.getId());
        dto.setTitre(document.getTitre());
        dto.setAuteur(document.getAuteur());
        dto.setEditeur(document.getEditeur());
        dto.setAnnee(document.getAnnee());
        dto.setCopiesDisponible(document.getCopiesDisponible());
        return dto;
    }
}
