package ca.cal.tp2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpruntDTO {
    private Long id;
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevu;
    private LocalDate dateRetourReel;
    private List<String> documentTitres;
}
