package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Admin;
import com.odkmali.backendHub.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


@Service
public class AdminServiceImplements implements AdminService{

    @Autowired
    AdminRepo adminRepo;

    @Override
    public List<KafkaProperties.Admin> getAllAdmin() {
        return adminRepo.getAllAdmin();
    }

    @Override
    public List<Admin> getAllAdminInactif() {return  adminRepo.getAllAdminInactif();}

    @Override
    public Admin getAdminById(Long id) {
        return adminRepo.findById(id).get();
    }

    @Override
    public List<Admin> getAdminByEtat(Etat etat) {
        return adminRepo.getAdminByEtat(etat);
    }

    @Override
    public List<Admin> getAdminByType(AdminEnum type) {
        return adminRepo.getAdminByType(type);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepo.deleteAdmin(id);

    }

    @Override
    public void restaurerAdmin(Long id) {
        adminRepo.restaurerAdmin(id);

    }

    @Override
    public Admin authAdmin(String login_admin, String password_admin) {
        return adminRepo.getAdminByLoginAndPassword(login_admin, password_admin);
    }

    public Admin modifierAdmin(Long id, Admin admin) {
        Admin a = adminRepo.findById(id).get();
        a.setNom_admin(admin.getNom_admin());
        a.setPrenom_admin(admin.getPrenom_admin());
        a.setLogin_admin(admin.getLogin_admin());
        a.setEmail_admin(admin.getEmail_admin());
        a.setTel_admin(admin.getTel_admin());
        a.setPhoto_admin(admin.getPhoto_admin());
        a.setType(admin.getType());
        a.setGenre(admin.getGenre());
        a.setPassword_admin(admin.getPassword_admin());
        return adminRepo.save(a);
    }

    public byte[] getPhoto(Long id) throws IOException {
        Admin a = adminRepo.getAdminById(id);
        String iconPhoto = a.getPhoto_admin();
        File file = new File ("src/main/resources/Images/Admin" + a.getId_admin() + "/" + iconPhoto);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    public Admin saveAdmin(Admin admin, MultipartFile photo) throws IOException {
        Optional<Admin> optionalAdmin = adminRepo.findAdmin(admin.getLogin_admin());

        if(optionalAdmin.isPresent()){
            System.out.println("Ce login existe déja");
        }else{
            adminRepo.save(admin);
        }
        return (admin);
    }

    public Integer nombreAdmin() {
        return adminRepo.nombreAdmin();
    }


    public Integer nombreAdminH() {
        return adminRepo.nombreAdminHomme();
    }


    public Integer nombreAdminF() {
        return adminRepo.nombreAdminFemme();
    }

}
