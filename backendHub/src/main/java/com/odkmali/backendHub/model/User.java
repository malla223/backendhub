package com.odkmali.backendHub.model;

import com.odkmali.backendHub.enumeration.Etat;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String nom_user;
    private String prenom_user;
    @NotNull
    @Column(unique=true)
    private String login_user;
    @NotNull
    private String password_user;
    private String adresse_user;
    @NotNull
    @Column(unique=true)
    private Long tel_user;
    private String photo_user;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.actif;

}
