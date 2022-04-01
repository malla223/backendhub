package com.odkmali.backendHub.model;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.enumeration.Notifi;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @ManyToOne
    private Niveau niveau;
    @NotNull
    private String photo_don;
    private String storie;
    private LocalDateTime date = LocalDateTime.now();
    @ManyToOne
    private User user;
    @ManyToOne
    private Categorie categorie;
    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.attente;
    @Enumerated(EnumType.STRING)
    private Notifi notifi = Notifi.nomLu;

}
