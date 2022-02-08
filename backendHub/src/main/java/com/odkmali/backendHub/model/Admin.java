package com.odkmali.backendHub.model;

import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
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
    private String email_admin;
    private Long tel_admin;
    @Enumerated(EnumType.STRING)
    @NotNull
    private AdminEnum type;

    private String photo;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.actif;

}
