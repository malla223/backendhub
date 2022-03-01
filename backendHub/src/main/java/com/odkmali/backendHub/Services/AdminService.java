package com.odkmali.backendHub.Services;


import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    public List<Admin> getAllAdmin();
    public Admin getAdminById(Long id);
    public List<Admin> getAdminByEtat(Etat etat);
    public List<Admin> getAdminByType(AdminEnum type);
    public void deleteAdmin(Long id);
    public void restaurerAdmin(Long id);
}
