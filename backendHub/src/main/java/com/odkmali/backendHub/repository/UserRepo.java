package com.odkmali.backendHub.repository;

import com.odkmali.backendHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = " SELECT u FROM User u WHERE u.etat=:etat ")
    public List<User> getAllUserByEtat(@Param("etat") String etat);

    @Query(value = " SELECT u FROM User u WHERE u.etat='actif' ")
    public List<User> getAllUser();

    @Query(value = " SELECT u FROM User u WHERE u.etat='actif' AND id_user=:id_user ")
    public User getUserById(@Param("id_user") Long id);

    @Query(value = " UPDATE User SET etat='inactif' WHERE id_user=:id_user ")
    @Modifying
    public void deleteUser(@Param("id_user") Long id);

    @Query(value = "UPDATE User SET etat='actif' WHERE id_user=:id_user")
    @Modifying
    public void restaurerUser(@Param("id_user") Long id);

}
