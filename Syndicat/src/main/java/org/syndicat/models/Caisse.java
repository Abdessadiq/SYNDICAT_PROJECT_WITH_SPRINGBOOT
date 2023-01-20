package org.syndicat.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Caisse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(length =100 )
    private String detailType;
    @Temporal(TemporalType.DATE)
    private Date date;
    private double somme;
    @ManyToOne
    private Immeuble immeuble;
    @ManyToOne
    private Utilisateur utilisateur;
}
