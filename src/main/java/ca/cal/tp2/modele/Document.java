package ca.cal.tp2.modele;
import jakarta.persistence.*;
import org.w3c.dom.DocumentType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "document")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String auteur;
    private String editeur;
    private int annee;
    private int copiesDisponible;

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", annee=" + annee +
                ", copiesAvailable=" + copiesDisponible +
                '}';
    }
}
