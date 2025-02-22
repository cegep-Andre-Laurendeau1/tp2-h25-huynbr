package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Entity
@DiscriminatorValue("CD")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CD {
    private int duree;
    private String genre;

    @Override
    public String toString() {
        return "CD{" +
                "duree=" + duree +
                ", genre='" + genre + '\'' +
                '}';
    }
}
