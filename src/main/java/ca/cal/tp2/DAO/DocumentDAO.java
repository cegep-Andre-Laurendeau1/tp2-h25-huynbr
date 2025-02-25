package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Document;

import java.util.List;

public interface DocumentDAO {
    Document findById(Long id);
    void save(Document document);

    List<Document> searchBytitre(String titre);

    List<Document> findByAuteur(String auteur);

    List<Document> findByYear(int annee);
    List<Document> findByEditeur(String editeur);
}
