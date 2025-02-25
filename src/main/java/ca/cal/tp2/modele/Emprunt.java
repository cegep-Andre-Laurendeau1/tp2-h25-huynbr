package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "emprunt")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate dateEmprunt;
    @Temporal(TemporalType.DATE)
    private LocalDate dateRetourPrevu;
    @Temporal(TemporalType.DATE)
    private LocalDate dateRetourReel;
    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;
    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL)
    private List<EmpruntDocument> empruntDocuments;
}
