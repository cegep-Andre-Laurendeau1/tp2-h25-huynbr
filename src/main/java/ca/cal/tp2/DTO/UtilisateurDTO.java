package ca.cal.tp2.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UtilisateurDTO {
    private long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;

    @Override
    public String toString() {
        return "UtilisateurDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", address='" + adresse + '\'' +
                ", address='" + email + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
