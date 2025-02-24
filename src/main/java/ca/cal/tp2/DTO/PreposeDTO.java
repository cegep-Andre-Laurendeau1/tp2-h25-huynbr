package ca.cal.tp2.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PreposeDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String address;
    private String email;
    private String telephone;
}
