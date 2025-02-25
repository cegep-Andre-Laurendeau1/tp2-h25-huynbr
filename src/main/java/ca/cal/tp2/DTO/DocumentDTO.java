package ca.cal.tp2.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocumentDTO {
    private Long id;
    private String titre;
    private String auteur;
    private String editeur;
    private int annee;
    private int copiesDisponible;
}
