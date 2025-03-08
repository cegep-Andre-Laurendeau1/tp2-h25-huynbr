package ca.cal.tp2.Service;

import ca.cal.tp2.DAO.EmprunteurDAO;
import ca.cal.tp2.DTO.EmprunteurDTO;
import ca.cal.tp2.modele.Emprunteur;

public class EmprunteurService {
    private final EmprunteurDAO emprunteurDAO;

    public EmprunteurService(EmprunteurDAO emprunteurDAO) {
        this.emprunteurDAO = emprunteurDAO;
    }

    public EmprunteurDTO createEmprunteur(String nom, String prenom, String adresse, String email, String telephone) {
        Emprunteur emprunteur = new Emprunteur();
        emprunteur.setNom(nom);
        emprunteur.setPrenom(prenom);
        emprunteur.setAdresse(adresse);
        emprunteur.setEmail(email);
        emprunteur.setTelephone(telephone);
        emprunteurDAO.save(emprunteur);
        return toDTO(emprunteur);
    }
    private EmprunteurDTO toDTO(Emprunteur emprunteur) {
        return new EmprunteurDTO(emprunteur.getId(), emprunteur.getNom()
                , emprunteur.getPrenom(), emprunteur.getAdresse()
                , emprunteur.getEmail(), emprunteur.getTelephone());
    }
    public EmprunteurDTO getEmprunteur(Long id) {
        Emprunteur emprunteur = emprunteurDAO.findById(id);
        if (emprunteur != null) {
            return toDTO(emprunteur);
        }
        else {
            return null;
        }
    }

}
