package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CDDTO {
    private Long id;
    private String titre;
    private String auteur;
    private String editeur;
    private Integer annee;
    private Integer duree;
    private String genre;
    private int copiesAvailable;
}
