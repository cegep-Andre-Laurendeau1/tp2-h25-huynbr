package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;

import java.util.List;

public interface EmprunteurDAO {
    void save(Emprunteur emprunteur);
    Emprunteur findById(Long id);
    List<Emprunt> findByEmprunteur(Emprunteur emprunteur);
    void save(Emprunt emprunt);
}
