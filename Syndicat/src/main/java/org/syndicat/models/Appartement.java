package org.syndicat.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Appartement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private int numeroEtage;
    @ManyToOne
    private Immeuble immeuble;
    @OneToMany(mappedBy = "appartement")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Utilisateur> utilisateurs;
}
