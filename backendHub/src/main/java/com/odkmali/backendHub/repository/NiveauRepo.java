package com.odkmali.backendHub.repository;

import com.odkmali.backendHub.model.Categorie;
import com.odkmali.backendHub.model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NiveauRepo extends JpaRepository<Niveau, Long> {

    @Query("SELECT n FROM Niveau n WHERE n.libelle_niveau = :libelle_niveau")
    Optional<Niveau> findNiveau(@Param("libelle_niveau") String libelle);
}
