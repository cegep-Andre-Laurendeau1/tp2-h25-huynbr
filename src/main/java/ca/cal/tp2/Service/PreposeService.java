package ca.cal.tp2.Service;

import ca.cal.tp2.DAO.*;
import ca.cal.tp2.DTO.CDDTO;
import ca.cal.tp2.DTO.DVDDTO;
import ca.cal.tp2.DTO.LivreDTO;
import ca.cal.tp2.modele.*;

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
        DVD dvd = new DVD();
        dvd.setTitre(dvdDTO.getTitre());
        dvd.setAuteur(dvdDTO.getAuteur());
        dvd.setEditeur(dvdDTO.getEditeur());
        dvd.setAnnee(dvdDTO.getAnnee());
        dvd.setCopiesDisponible(dvdDTO.getCopiesAvailable());
        dvd.setDuree(dvdDTO.getDuree());
        dvd.setGenre(dvdDTO.getGenre());
        dvddao.save(dvd);
    }
    public void addLivre(LivreDTO livreDTO) {
        Livre livre = new Livre();
        livre.setTitre(livreDTO.getTitre());
        livre.setAuteur(livreDTO.getAuteur());
        livre.setEditeur(livreDTO.getEditeur());
        livre.setAnnee(livreDTO.getAnnee());
        livre.setCopiesDisponible(livreDTO.getCopiesAvailable());
        livre.setNombrePages(livreDTO.getNombrePages());
        livre.setGenre(livreDTO.getGenre());
        livredao.save(livre);
    }

}
