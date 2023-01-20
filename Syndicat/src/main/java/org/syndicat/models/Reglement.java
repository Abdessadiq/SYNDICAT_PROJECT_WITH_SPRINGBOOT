package org.syndicat.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Reglement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroArticle;
    @Column(columnDefinition = "TEXT")
    private String contenuArticle;
}
