package org.syndicat.models;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 80)
    private String nom;
    @Column(length = 80)
    private String prenom;
    @Column(length = 100)
    private String email;
    @Column(length = 25)
    private String password;
    @Column(length = 200)
    private String adresse;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(length = 20)
    private String situationFamiliale;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(length = 20)
    private String tel;

    @Enumerated(EnumType.STRING)
    private TypeUtilisateur typeUtilisateur;

    @ManyToOne
    private Immeuble immeuble;
    @ManyToOne
    private Appartement appartement;

    @OneToMany(mappedBy = "utilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<AnnonceUtilisateur> annonceUtilisateurs;

    @OneToMany(mappedBy = "utilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Caisse>  caisses;
}
