package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "amende")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Amende {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double montant;
    @Temporal(TemporalType.DATE)
    private LocalDate dateCreation;
    private boolean status;
}
