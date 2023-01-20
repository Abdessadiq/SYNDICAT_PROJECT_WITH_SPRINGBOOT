package org.syndicat.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AnnonceUtilisateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String sujet;
    @Column(columnDefinition = "TEXT")
    private String contenu;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Immeuble immeuble;
}
