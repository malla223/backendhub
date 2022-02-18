package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Admin;
import com.odkmali.backendHub.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminServiceImplements implements AdminService{

    @Autowired
    AdminRepo adminRepo;

    public Admin SaveAdmin(Admin admin){
        Optional<Admin> optionalAdmin = adminRepo.findAdmin(admin.getLogin_admin());

        if(optionalAdmin.isPresent()){
            System.out.println("Ce login existe deja!");
        }else{
            adminRepo.save(admin);
        }
        return admin;
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepo.getAllAdmin();
    }

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
    public Admin modifierAdmin(Long id, Admin admin) {
        Admin a = adminRepo.findById(id).get();
        a.setNom_admin(admin.getNom_admin());
        a.setPrenom_admin(admin.getPrenom_admin());
        a.setLogin_admin(admin.getLogin_admin());
        a.setEmail_admin(admin.getEmail_admin());
        a.setTel_admin(admin.getTel_admin());
        a.setPhoto_admin(admin.getPhoto_admin());
        a.setType(admin.getType());
        return adminRepo.save(a);
    }


}
