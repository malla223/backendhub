package com.odkmali.backendHub.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.enumeration.Genre;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private AdminEnum type;
    private String photo_admin;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.actif;
    @Enumerated(EnumType.STRING)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Genre genre;


}
