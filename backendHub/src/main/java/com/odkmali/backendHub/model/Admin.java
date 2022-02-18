package com.odkmali.backendHub.model;

import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_admin;
    @NotNull
    private String nom_admin;
    @NotNull
    private String prenom_admin;
    @NotNull
    private String login_admin;
    @NotNull
    private String password_admin;
    @Column(unique=true)
    private String email_admin;
    @Column(unique=true)
    private Long tel_admin;
    @Enumerated(EnumType.STRING)
    @NotNull
    private AdminEnum type;
    private String photo_admin;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.actif;


}
