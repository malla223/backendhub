package com.odkmali.backendHub.repository;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.Don;
import com.odkmali.backendHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DonRepo extends JpaRepository<Don, Long> {

    @Query(value = " SELECT d FROM Don d WHERE d.etat=:etat ")
    public List<Don> getAllDonByEtat(@Param("etat") Etat etat);

    @Query(value = " SELECT d FROM Don d WHERE d.etat='confirmer' ")
    public List<Don> getAllDonConfirmer();

    @Query(value = " SELECT d FROM Don d WHERE d.etat='attente' ")
    public List<Don> getAllDonAttente();

    @Query(value = " SELECT d FROM Don d WHERE d.etat='encours' ")
    public List<Don> getAllDonEncours();

    @Query(value = " UPDATE Don SET etat='attente' WHERE id_don=:id_don")
    @Modifying
    public void attenteDon(@Param("id_don")Long id);

    @Query(value = " UPDATE Don SET etat='confirmer' WHERE id_don=:id_don")
    @Modifying
    public void confirmerDon(@Param("id_don")Long id);

    @Query(value = " UPDATE Don SET etat='encours' WHERE id_don=:id_don")
    @Modifying
    public void encoursDon(@Param("id_don")Long id);

    @Query(value = " UPDATE Don SET etat='inactif' WHERE id_don=:id_don")
    @Modifying
    public void annulerDon(@Param("id_don")Long id);

    @Query(value = " UPDATE Don SET etat='inactif' WHERE id_don=:id_don")
    @Modifying
    public void deleteDon(@Param("id_don")Long id);

    @Query(value = " UPDATE Don SET etat='demandeConfirmer' WHERE id_don=:id_don")
    @Modifying
    public void demandeConfirmer(@Param("id_don")Long id);

    @Query(value = "SELECT d FROM Don d WHERE d.etat='attente' AND d.user=:user")
    public List<Don> getDonByUser(@Param("user")User user);

    @Query(value = "SELECT COUNT (*) FROM Don WHERE etat='confirmer'")
    Integer nbreDonConfirmer();

    @Query(value = "SELECT COUNT (*) FROM Don WHERE etat='attente'")
    Integer nbreDonAttente();

    @Query(value = "SELECT COUNT (*) FROM Don WHERE etat='attente' AND user=:user")
    Integer nombreDonAttenteByUser(@Param("user") User user);
}
