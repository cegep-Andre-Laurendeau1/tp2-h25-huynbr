package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "prepose")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Prepose extends Utilisateur {

}
