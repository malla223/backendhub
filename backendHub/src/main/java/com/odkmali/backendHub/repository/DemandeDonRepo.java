package com.odkmali.backendHub.repository;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DemandeDonRepo extends JpaRepository<DemandeDon, Long> {

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.etat='attente'")
    public List<DemandeDon> getDemandeDonAttente();

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.etat='attente' AND d.user=:user")
    public List<DemandeDon> getDemandeDonByUser(@Param("user")User user);

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.etat='confirmer'")
    public List<DemandeDon> getDemandeConfirmer();

    @Query(value = "UPDATE DemandeDon SET etat='confirmer' WHERE id_demande=:id_demande")
    @Modifying
    public void confirmerDemandeDon(@Param("id_demande")Long id_demande);

    @Query(value = "UPDATE DemandeDon SET etat='inactif' WHERE id_demande=:id_demande")
    @Modifying
    public void annulerDemande(@Param("id_demande")Long id_demande);
}