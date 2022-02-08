package com.odkmali.backendHub.model;

import com.odkmali.backendHub.enumeration.Etat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Eleve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_eleve;
    @NotNull
    private String nom_eleve;
    @NotNull
    private String prenom_eleve;
    @NotNull
    private String classe_eleve;
    @NotNull
    private String nomcomplet_parent;
    @NotNull
    private String contact_parent;
    @ManyToOne
    @NotNull
    private Ecole ecole;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.actif;

}
