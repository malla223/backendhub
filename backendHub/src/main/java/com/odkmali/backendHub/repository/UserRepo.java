package com.odkmali.backendHub.repository;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login_user = :login_user")
    Optional<User> findUser(@Param("login_user") String login);

    @Query(value = " SELECT u FROM User u WHERE u.login_user=:login_user AND u.password_user=:password_user")
    User getUserByLoginAndPassword(@Param("login_user") String login, @Param("password_user") String password);

    @Query(value = " SELECT u FROM User u WHERE u.etat =:etat ")
    public List<User> getAllUserByEtat(@Param("etat") Etat etat);

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

    @Query(value = "SELECT COUNT (*) FROM User WHERE etat='actif'")
    public Integer nombreUser();

}
