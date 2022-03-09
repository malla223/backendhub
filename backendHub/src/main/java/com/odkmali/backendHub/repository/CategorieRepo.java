package com.odkmali.backendHub.repository;

import com.odkmali.backendHub.model.Categorie;
import com.odkmali.backendHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategorieRepo extends JpaRepository<Categorie, Long> {

    @Query("SELECT c FROM Categorie c WHERE c.libelle_cat = :libelle_cat")
    Optional<Categorie> findCategorie(@Param("libelle_cat") String libelle);

    @Query("SELECT c FROM Categorie c WHERE c.libelle_cat = :libelle_cat")
    Categorie getCategorieLibele(@Param("libelle_cat") String libelle);
}
