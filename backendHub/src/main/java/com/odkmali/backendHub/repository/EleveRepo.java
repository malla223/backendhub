package com.odkmali.backendHub.repository;


import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface EleveRepo extends JpaRepository<Eleve, Long> {

    @Query(value="SELECT e FROM Eleve e WHERE e.etat=:etat ")
    public List<Eleve> getEleveByEtat(@Param("etat") Etat etat);

    @Query(value="SELECT e FROM Eleve e WHERE e.etat='actif' AND e.id_eleve = : id_eleve ")
    public Eleve getEleveById(@Param("id_eleve")Long id);

    @Query(value="SELECT e FROM Eleve e WHERE e.etat='actif' ")
    public List<Eleve> getAllEleve();

    @Query(value = "UPDATE Eleve SET etat='inactif' WHERE id_eleve=:id_eleve")
    @Modifying
    public void deleteEleve(@Param("id_eleve") Long id);

    @Query(value="UPDATE Eleve SET  etat='actif' WHERE id_eleve=:id_eleve")
    @Modifying
    public void restaurerEleve(@Param("id_eleve")Long id);
}
