package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Livre")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livre extends Document{
    private int nombrePages;
    private String genre;

    @Override
    public String toString() {
        return "Livre{" + " id=" + getId() +
                "nombrePages=" + nombrePages +
                ", genre='" + genre + '\'' +
                '}';
    }
}
