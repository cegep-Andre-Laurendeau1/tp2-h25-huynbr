package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("DVD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DVD extends Document {
    private int duree;
    private String genre;

    @Override
    public String toString() {
        return "DVD{" + " id=" + getId() +
                "duree=" + duree +
                ", genre='" + genre + '\'' +
                '}';
    }
}
