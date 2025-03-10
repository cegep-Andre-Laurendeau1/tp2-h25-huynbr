package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@DiscriminatorValue("CD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CD extends Document{
    private int duree;
    private String genre;

    @Override
    public String toString() {
        return "CD{" + " id=" + getId() +
                "duree=" + duree +
                ", genre='" + genre + '\'' +
                '}';
    }
}
