package com.odkmali.backendHub.model;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.enumeration.TypeUser;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ecole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ecole;
    @NotNull
    private String nom_ecole;
    @NotNull
    private String login_ecole;
    @NotNull
    private String password_ecole;
    private String site_ecole;
    @NotNull
    private String email_ecole;
    @NotNull
    private String adresse_ecole;
    @NotNull
    private String contrat_ecole;
    @NotNull
    @Column(unique = true)
    private Long tel_ecole;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.inactif;
    @Enumerated(EnumType.STRING)
    private TypeUser type = TypeUser.ecole;
}
