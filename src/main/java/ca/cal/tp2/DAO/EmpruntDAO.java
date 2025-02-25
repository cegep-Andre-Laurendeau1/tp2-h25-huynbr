package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Emprunt;

import java.util.List;

public interface EmpruntDAO {
    Emprunt findById(Long id);
    List<Emprunt> findAllByEmpruntId(Long id);
    void save(Emprunt emprunt);
    List<Emprunt> findByEmpruntId(Long id);
}
