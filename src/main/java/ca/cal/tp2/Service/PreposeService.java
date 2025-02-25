package ca.cal.tp2.Service;

import ca.cal.tp2.DAO.PreposeDAO;
import ca.cal.tp2.DTO.PreposeDTO;
import ca.cal.tp2.modele.Prepose;

public class PreposeService {
    private final PreposeDAO preposeDAO;

    public PreposeService(PreposeDAO preposeDAO) {
        this.preposeDAO = preposeDAO;
    }
    public Prepose createPrepose(String nom, String prenom, String adresse, String email, String telephone) {
        Prepose prepose = new Prepose();
        prepose.setNom(nom);
        prepose.setPrenom(prenom);
        prepose.setAdresse(adresse);
        prepose.setEmail(email);
        prepose.setTelephone(telephone);
        preposeDAO.save(prepose);
        return prepose;
    }
}
