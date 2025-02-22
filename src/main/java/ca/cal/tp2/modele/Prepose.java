package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prepose")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Prepose extends Utilisateur {

}
