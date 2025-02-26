package ca.cal.tp2.Service;

import ca.cal.tp2.DAO.*;
import ca.cal.tp2.DTO.CDDTO;
import ca.cal.tp2.DTO.DVDDTO;
import ca.cal.tp2.DTO.LivreDTO;
import ca.cal.tp2.DTO.PreposeDTO;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Prepose;

public class PreposeService {
    private final PreposeDAO preposeDAO;
    private final CDDAO cddao;
    private final DVDDAO dvddao;
    private final LivreDAO livredao;
    private final DocumentDAO documentdao;

    public PreposeService(CDDAO cddao, DVDDAO dvdDAO, LivreDAO livreDAO, DocumentDAO documentDAO, PreposeDAO preposeDAO) {
        this.cddao = cddao;
        this.dvddao = dvdDAO;
        this.livredao = livreDAO;
        this.documentdao = documentDAO;
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
    public void addCD(CDDTO cdDTO) {
        CD cd = new CD();
        cd.setTitre(cdDTO.getTitre());
        cd.setAuteur(cdDTO.getAuteur());
        cd.setEditeur(cdDTO.getEditeur());
        cd.setAnnee(cdDTO.getAnnee());
        cd.setCopiesDisponible(cdDTO.getCopiesAvailable());
        cd.setDuree(cdDTO.getDuree());
        cd.setGenre(cdDTO.getGenre());
        cddao.save(cd);
    }
    public void addDVD(DVDDTO dvdDTO) {
    }
    public void addLivre(LivreDTO livreDTO) {

    }
}
