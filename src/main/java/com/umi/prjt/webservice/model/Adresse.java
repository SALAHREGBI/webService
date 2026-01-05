package com.umi.prjt.webservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(length = 100)
    private String rue;
    @NonNull
    @Column(length = 100)
    private String ville;
    @NonNull
    @Column(length = 100)
    private String codePostal;
    @NonNull
    private Long idPersonne;
    @Transient
    private Personne personne;
}

