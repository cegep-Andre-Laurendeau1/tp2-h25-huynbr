package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Livre;

import java.util.List;

public interface LivreDAO {
    void save(Livre livre);
    Livre findById(Long id);
    List<Livre> findAll();
}
