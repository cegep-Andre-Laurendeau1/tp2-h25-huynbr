package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DVDDTO {
    private Long id;
    private String titre;
    private String auteur;
    private String editeur;
    private int annee;
    private int copiesAvailable;
    private int duree;
    private String genre;
}
