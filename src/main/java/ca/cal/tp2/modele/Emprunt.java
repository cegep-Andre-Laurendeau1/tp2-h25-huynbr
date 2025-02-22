package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    private Date dateEmprunt;
    @Temporal(TemporalType.DATE)
    private Date dateRetourPrevu;
    @Temporal(TemporalType.DATE)
    private Date dateRetourReel;
    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;
//    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL)
//    private List<EmpruntDocument> empruntDocuments;
}
