package ca.cal.tp2;

import ca.cal.tp2.DAO.EmprunteurDAO;
import ca.cal.tp2.DAO.EmprunteurDAOImpl;
import ca.cal.tp2.DTO.EmprunteurDTO;
import ca.cal.tp2.Service.EmprunteurService;
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

        System.out.println("Enregistrement d'un nouveau Emprunteur...");
        EmprunteurDTO emprunteur = emprunteurService.createEmprunteur("Smith", "John", "rue 1234", "johnsmith@gmail.com", "5141234567");
        System.out.println("Enregistrement d'un nouveau Emprunteur Réussi : " + emprunteur.getId() + " " + emprunteur.getNom() + " " + emprunteur.getPrenom() + " " + emprunteur.getEmail() + " "
                + emprunteur.getAddress()+ " " + emprunteur.getTelephone() );
    }
}
