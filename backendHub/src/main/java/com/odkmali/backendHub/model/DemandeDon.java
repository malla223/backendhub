package com.odkmali.backendHub.model;

import com.odkmali.backendHub.enumeration.Etat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_demande;
    @NotNull
    private String nom_eleve;
    @NotNull
    private String classe;
    @NotNull
    private String nom_ecole;
    @NotNull
    private String adresse_ecole;
    @NotNull
    private String nom_parent;
    @NotNull
    private Long tel_parent;
    @NotNull
    private Long tel_ecole;
    private LocalDateTime date = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.attente;
    @OneToOne
    private Don don;
    @OneToOne
    private User user;
    @OneToOne
    private Ecole ecole;
}
