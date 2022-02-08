package com.odkmali.backendHub.model;

import com.odkmali.backendHub.enumeration.Etat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Don {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_don;
    @NotNull
    private String libelle_don;
    @NotNull
    private String niveau_don;
    @NotNull
    private String photo_don;
    @ManyToOne
    private Ecole ecole;
    @ManyToOne
    private Eleve eleve;
    @ManyToOne
    private User user;
    @ManyToOne
    private Categorie categorie;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.attente;

}
