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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ecole implements Serializable {

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
    private String adresse_ecole;
    @NotNull
    private Long tel_ecole;
}
