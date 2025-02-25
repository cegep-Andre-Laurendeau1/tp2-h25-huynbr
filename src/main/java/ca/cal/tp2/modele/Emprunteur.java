package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "emprunteur")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Emprunteur extends Utilisateur{
    @OneToMany(mappedBy = "emprunteur")
    private Set<Emprunt> emprunts = new HashSet<>();
    @OneToMany(mappedBy = "emprunteur")
    private Set<Amende> amendes = new HashSet<>();
}
