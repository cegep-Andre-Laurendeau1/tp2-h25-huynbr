package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "emprunteur")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Emprunteur extends Utilisateur{
    @OneToMany(mappedBy = "emprunteur")
    private Set<Emprunt> emprunts = new HashSet<>();
}
