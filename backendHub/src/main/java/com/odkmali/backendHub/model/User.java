package com.odkmali.backendHub.model;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.enumeration.Genre;
import com.odkmali.backendHub.enumeration.TypeUser;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @NotNull
    private String nom_user;
    @NotNull
    private String prenom_user;
    private LocalDate datenaiss ;//For reference
    @NotNull
    private String email_user;
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
    @Enumerated(EnumType.STRING)
    private TypeUser type = TypeUser.user;
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
