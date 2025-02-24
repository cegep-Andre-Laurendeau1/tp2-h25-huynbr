package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Utilisateur;

public interface UtilisateurDAO {
    Utilisateur findById(Long id);
    void save(Utilisateur utilisateur);
}
