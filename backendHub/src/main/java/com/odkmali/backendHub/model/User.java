package com.odkmali.backendHub.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String nom_user;
    private String prenom_user;
    @NotNull
    private String login_user;
    @NotNull
    private String password_user;
    private String adresse_user;
    @NotNull
    private Long tel_user;
    private String photo_user;

}
