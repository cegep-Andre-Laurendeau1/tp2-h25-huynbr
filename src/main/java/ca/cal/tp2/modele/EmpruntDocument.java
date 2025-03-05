package ca.cal.tp2.modele;
import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpruntDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate dateRetour;

    @ManyToOne
    @JoinColumn(name = "emprunt_id")
    private Emprunt emprunt;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;
}
