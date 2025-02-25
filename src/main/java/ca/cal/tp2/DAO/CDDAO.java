package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.CD;

import java.util.List;

public interface CDDAO {
    void save(CD cd);
    CD findById(Long id);
    List<CD> findAll();
}
