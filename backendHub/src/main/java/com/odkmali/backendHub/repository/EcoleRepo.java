package com.odkmali.backendHub.repository;


import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Ecole;
import com.odkmali.backendHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface EcoleRepo extends JpaRepository <Ecole, Long>{


    @Query(value="SELECT e FROM Ecole e WHERE e.login_ecole=:login_ecole")
    Optional<Ecole> findEcole(@Param("login_ecole")String login_ecole);

    @Query(value = " SELECT e FROM Ecole e WHERE e.login_ecole=:login_ecole AND e.password_ecole=:password_ecole AND e.etat='actif'")
    Ecole getEcoleByLoginAndPassword(@Param("login_ecole") String login, @Param("password_ecole") String password);

    @Query(value="SELECT e FROM Ecole e WHERE e.etat=:etat")
    public List <Ecole> getEcoleByEtat(@Param("etat") Etat etat);

    @Query(value= "SELECT e FROM Ecole e WHERE e.etat='actif'")
    public List<Ecole> getAllEcole();

    @Query(value= "SELECT e FROM Ecole e WHERE e.etat='attente'")
    public List<Ecole> getAllEcoleAttente();

    @Query(value="UPDATE Ecole SET etat='inactif' WHERE id_ecole=:id_ecole")
    @Modifying
    public void deleteEcole (@Param("id_ecole")Long id);

    @Query(value="UPDATE Ecole SET etat='actif' WHERE id_ecole=:id_ecole")
    @Modifying
    public void restaurerEcole (@Param("id_ecole")Long id);

    @Query(value = "SELECT e FROM Ecole e WHERE e.id_ecole =:id_ecole")
    public Ecole getEcoleById(@Param("id_ecole") Long id);
}
