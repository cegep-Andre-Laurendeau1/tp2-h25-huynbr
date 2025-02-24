package ca.cal.tp2.DAO;

import ca.cal.tp2.modele.Utilisateur;
import jakarta.persistence.EntityManager;

public class UtilisateurDaoImpl implements  UtilisateurDAO{
    private final EntityManager entityManager;

    public UtilisateurDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Utilisateur findById(Long id) {
        return entityManager.find(Utilisateur.class, id);
    }

    @Override
    public void save(Utilisateur utilisateur) {
        entityManager.persist(utilisateur);
    }
}
