package com.odkmali.backendHub.repository;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.Don;
import com.odkmali.backendHub.model.Ecole;
import com.odkmali.backendHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Transactional
public interface DemandeDonRepo extends JpaRepository<DemandeDon, Long> {

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.etat='attente' AND nom_ecole IS NOT NULL")
    public List<DemandeDon> getDemandeDonAttente();

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.etat='attente' AND nom_ecole=NULL")
    public List<DemandeDon> getDemandeDonEcoleAttente();

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.user=:user AND d.etat='attente' ORDER BY d.date DESC")
    public List<DemandeDon> getDemandeDonByUser(@Param("user")User user);

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.ecole=:ecole AND d.etat='attente' ORDER BY d.date DESC")
    public List<DemandeDon> getDemandeDonByEcole(@Param("ecole") Ecole ecole);

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.ecole=:ecole AND d.etat='confirmer' ORDER BY d.date DESC")
    public List<DemandeDon> getEleveByEcole(@Param("ecole")Ecole ecole);

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.etat='confirmer' AND nom_ecole IS NULL ORDER BY d.date DESC")
    public List<DemandeDon> getDemandeConfirmerEcole();

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.etat='confirmer' AND nom_ecole IS NOT NULL ORDER BY d.date DESC")
    public List<DemandeDon> getDemandeConfirmerUser();

    @Query(value = "SELECT d FROM DemandeDon d WHERE d.id_demande=:id_demande")
    public DemandeDon getDemandeAttenteById(@PathVariable("id_demande") Long id_demande);

    @Query(value = "UPDATE DemandeDon SET etat='confirmer' WHERE id_demande=:id_demande")
    @Modifying
    public void confirmerDemandeDon(@Param("id_demande")Long id_demande);

    @Query(value = "UPDATE DemandeDon SET etat='inactif' WHERE id_demande=:id_demande")
    @Modifying
    public void annulerDemande(@Param("id_demande")Long id_demande);


    @Query(value = "SELECT d FROM DemandeDon d WHERE d.don=:don AND d.user=:user")
    Optional<DemandeDon> findDemandeByDon(@Param("user") User user, @Param("don") Don don);

    @Query(value = "SELECT COUNT (*) FROM DemandeDon WHERE etat='confirmer'")
    Integer nombreDonRecu();

    @Query(value = "SELECT COUNT (*) FROM DemandeDon WHERE etat='attente'")
    Integer nombreDemandeAttente();

    @Query(value = "SELECT COUNT (*) FROM DemandeDon WHERE etat='attente' AND user=:user")
    Integer nombreDemandeAttenteByUser(@Param("user") User user);

    @Query(value = "SELECT COUNT (*) FROM DemandeDon WHERE etat='confirmer' AND user=:user")
    Integer nombreDonRecuByUser(@Param("user") User user);

    @Query(value = "SELECT COUNT (*) FROM DemandeDon WHERE etat='attente' AND ecole=:ecole")
    Integer nombreDemandeAttenteByEcole(@Param("ecole") Ecole ecole);

    @Query(value = "SELECT COUNT (*) FROM DemandeDon WHERE etat='confirmer' AND ecole=:ecole")
    Integer nombreDonRecuByEcole(@Param("ecole") Ecole ecole);

}
