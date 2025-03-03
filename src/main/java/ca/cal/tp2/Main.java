package ca.cal.tp2;

import ca.cal.tp2.DAO.*;
import ca.cal.tp2.DTO.*;
import ca.cal.tp2.Service.DocumentService;
import ca.cal.tp2.Service.EmprunteurService;
import ca.cal.tp2.Service.PreposeService;
import ca.cal.tp2.modele.Prepose;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws  InterruptedException, SQLException {
        TcpServer.createTcpServer();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2BryanHuynh.ex1");
        EntityManager em = emf.createEntityManager();
        EmprunteurDAO emprunteurDAO = new EmprunteurDAOImpl(em);
        EmprunteurService emprunteurService = new EmprunteurService(emprunteurDAO);
        PreposeDAO preposeDAO = new PreposeDAOImpl(em);
        CDDAO cdDAO = new CDDAOImpl(em);
        DVDDAO dvdDAO = new DVDDAOImpl(em);
        LivreDAO livreDAO = new LivreDAOImpl(em);
        DocumentDAO documentDAO = new DocumentDAOImpl(em);
        DocumentService documentService = new DocumentService(documentDAO);
        PreposeService preposeService = new PreposeService(cdDAO, dvdDAO, livreDAO, documentDAO, preposeDAO);

        System.out.println("Enregistrement d'un nouveau Emprunteur:");
        EmprunteurDTO emprunteur = emprunteurService.createEmprunteur("Smith", "John", "rue 1234", "johnsmith@gmail.com", "5141234567");
        System.out.println("Enregistrement d'un Emprunteur est Réussi : " + emprunteur.getId() + " " + emprunteur.getNom() + " " + emprunteur.getPrenom() + " " + emprunteur.getEmail() + " "
                + emprunteur.getAddress()+ " " + emprunteur.getTelephone() );

        Prepose prepose1 = preposeService.createPrepose("Doe", "Jane", "rue 0987", "janedoe@gmail.com", "5145554321");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Enregistrement d'un nouveau Emprunteur:");
        System.out.println("Enregistrement d'un Préposé est Réussi : " + prepose1.getId() + " " + prepose1.getNom() + " " + prepose1.getPrenom() + " " + prepose1.getEmail() + " "
                + prepose1.getAdresse() + prepose1.getTelephone());
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Ajout d'un CD à la bibliothèque:");
        CDDTO cddto = new CDDTO(null, "Disco Night", "Artist", "Editeur1", 2025, 3, 30, "Disco");
        preposeService.addCD(cddto);
        System.out.println("CD ajouté à la bibliothèque avec succès.");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Ajout d'un DVD à la bibliothèque:");
        DVDDTO dvddto = new DVDDTO(null, "Akira", "Katsuhiro Otomo", "Editeur2", 1988, 1, 124, "Sci-fi");
        preposeService.addDVD(dvddto);
        System.out.println("DVD ajouté à la bibliothèque avec succès.");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Ajout d'un Livre à la bibliothèque:");
        LivreDTO livreDTO = new LivreDTO(null, "Lord of the rings", "Tolkien", "Editeur3", 1954, 0, 1216, "Fantasy");
        preposeService.addLivre(livreDTO);
        System.out.println("Livre ajouté à la bibliothèque avec succès.");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Ajout d'un Livre à la bibliothèque...");
        LivreDTO livreDTO2 = new LivreDTO(null, "Dune", "Frank Herbert", "Editeur4", 1965, 5, 900, "Sci-fi");
        preposeService.addLivre(livreDTO2);
        System.out.println("Livre ajouté à la bibliothèque avec succès.");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Ajout d'un Livre à la bibliothèque:");
        LivreDTO livreDTO3 = new LivreDTO(null, "Harry Potter", "JK Rowling", "Editeur5", 1977, 2, 309, "Fantasy");
        preposeService.addLivre(livreDTO3);
        System.out.println("Livre ajouté à la bibliothèque avec succès.");
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Recherche de livre par titre:");
        documentService.chercherParTitre("rings").forEach(doc ->
                System.out.println("Titre : " + doc.getTitre() + " | Auteur : " + doc.getAuteur() + " | Éditeur : " + doc.getEditeur())
        );
        System.out.println("---------------------------------------------------------------------------");
    }
}
