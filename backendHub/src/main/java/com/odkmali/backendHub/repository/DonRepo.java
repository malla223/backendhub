package com.odkmali.backendHub.repository;

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
    public List<Don> getAllDonByEtat(@Param("etat") String etat);

    @Query(value = " SELECT d FROM Don d WHERE d.etat='actif' ")
    public List<Don> getAllDon();

    @Query(value = " SELECT d FROM Don d WHERE d.etat='inactif' ")
    public List<Don> getAllDonInactif();

    @Query(value = " SELECT d FROM Don d WHERE d.etat='confirmer' ")
    public List<Don> getAllDonConfirmer();

    @Query(value = " SELECT d FROM Don d WHERE d.etat='attente' ")
    public List<Don> getAllDonAttente();

    @Query(value = " SELECT d FROM Don d WHERE d.etat='encours' ")
    public List<Don> getAllDonEncours();

    @Query(value = " UPDATE Don SET etat='inactif' WHERE id_don=:id_don")
    public void deleteDon(@Param("id_don")Long id);

    @Query(value = " UPDATE Don SET etat='attente' WHERE id_don=:id_don")
    public void restaurerDon(@Param("id_don")Long id);

    @Query(value = " UPDATE Don SET etat='actif' WHERE id_don=:id_don")
    public void activerDon(@Param("id_don")Long id);

    @Query(value = " UPDATE Don SET etat='confirmer' WHERE id_don=:id_don")
    public void confirmerDon(@Param("id_don")Long id);

    @Query(value = " UPDATE Don SET etat='encours' WHERE id_don=:id_don")
    public void encoursDon(@Param("id_don")Long id);
}
