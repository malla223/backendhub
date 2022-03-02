package com.odkmali.backendHub.Services;


import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Admin;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface AdminService {

    public List<Admin> getAllAdmin();
    public Admin getAdminById(Long id);
    public List<Admin> getAdminByEtat(Etat etat);
    public List<Admin> getAdminByType(AdminEnum type);
    public void deleteAdmin(Long id);
    public void restaurerAdmin(Long id);
    public Admin authAdmin(String login_admin, String password_admin);
    public byte[] getPhoto(Long id) throws IOException;
    public Admin saveAdmin(Admin admin, MultipartFile photo) throws IOException;
    public Integer nombreAdmin();
    public Integer nombreAdminH();
    public Integer nombreAdminF();
}
