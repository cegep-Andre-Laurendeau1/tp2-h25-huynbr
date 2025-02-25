package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "amende")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Amende {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double montant;
    @Temporal(TemporalType.DATE)
    private LocalDate dateCreation;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;
}
