package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.DVD;

import java.util.List;

public interface DVDDAO {
    void save(DVD dvd);
    DVD findById(Long id);
    List<DVD> findAll();
}
