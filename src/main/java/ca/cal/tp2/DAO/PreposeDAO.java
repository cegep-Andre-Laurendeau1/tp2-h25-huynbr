package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Prepose;

import java.util.List;

public interface PreposeDAO {
    void save(Prepose prepose);

    Prepose findById(Long id);

    List<Prepose> findAll();
}
