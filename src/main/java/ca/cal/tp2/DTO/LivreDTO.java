package ca.cal.tp2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LivreDTO {
    private Long id;
    private String titre;
    private String auteur;
    private String editeur;
    private int annee;
    private int copiesAvailable;
    private int nombrePages;
    private String genre;
}
