package ca.cal.tp2.DTO;

import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AmendeDTO {
    private long id;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;
    private Emprunteur emprunteur;
}
