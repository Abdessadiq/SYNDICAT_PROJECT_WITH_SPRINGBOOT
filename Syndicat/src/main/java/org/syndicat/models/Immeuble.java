package org.syndicat.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Immeuble {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 80)
    private String nom;
    @Column(length = 60)
    private String vile;
    private int nombreEtages;
    private int nombreAppartements;
    @OneToMany(mappedBy = "immeuble")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Caisse> caisses;

    @OneToMany(mappedBy = "immeuble")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  Collection<Appartement> appartements;

    @OneToMany(mappedBy = "immeuble")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Utilisateur> utilisateurs;

    @OneToMany(mappedBy = "immeuble")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<AnnonceUtilisateur>  annonceUtilisateurs;
}
