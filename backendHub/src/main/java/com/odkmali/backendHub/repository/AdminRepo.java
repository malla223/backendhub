package com.odkmali.backendHub.repository;

import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    @Query(value="SELECT a FROM Admin a WHERE a.etat='actif' ")
    public List<Admin> getAllAdmin();

    @Query(value="SELECT a FROM Admin a WHERE a.etat='actif' AND a.id_admin=:id_admin")
    public Admin getAdminById (Long id);

    @Query(value="SELECT a FROM Admin a WHERE a.etat= 'actif' AND a.type= :type")
    public List <Admin> getAdminByType(@Param("type") AdminEnum type);

    @Query(value= "SELECT a FROM Admin a WHERE a.etat=:etat")
    public List<Admin> getAdminByEtat(@Param("etat")Etat etat);

    @Query(value="UPDATE Admin SET etat='inactif' WHERE id_admin=:id_admin")
    @Modifying
    public void deleteAdmin (@Param("id_admin")Long id);

    @Query(value="UPDATE Admin SET etat='actif' WHERE id_admin=:id_admin ")
    @Modifying
    public void restaurerAdmin (@Param("id_admin")Long id);

    @Query(value = "SELECT a FROM Admin a WHERE a.login_admin=:login_admin")
    Optional<Admin> findAdmin(@Param("login_admin") String login_admin);

    @Query(value = "SELECT a FROM Admin a WHERE a.login_admin=:login_admin AND a.password_admin=:password_admin")
    Admin getAdminByLoginAndPassword(@Param("login_admin")String login_admin, @Param("password_admin")String password_admin);

    @Query(value = "SELECT COUNT(*) FROM Admin WHERE etat='actif'")
    public Integer nombreAdmin();

}
