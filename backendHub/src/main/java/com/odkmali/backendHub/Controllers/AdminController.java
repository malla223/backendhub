package com.odkmali.backendHub.Controllers;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.odkmali.backendHub.Services.AdminServiceImplements;
import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Admin;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.modelPhoto.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminServiceImplements adminServiceImplements;

    @PostMapping("/saveAdmin")
    public Admin SaveAdmin(@RequestParam("data") String admin , @RequestParam("image") MultipartFile photo)
            throws JsonParseException, JsonMappingException, Exception{

        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        Admin a = new Admin();
        a.setPhoto_admin(fileName);

        Admin saveadmin = adminServiceImplements.saveAdmin(a, photo);
        String uploadDir = "src/main/resources/Images/" +saveadmin.getId_admin();

        FileUploadUtil.saveFile(uploadDir, fileName, photo);

        return (a);
    }

    @GetMapping("/getAllAdmin")
    @ResponseBody
    public List<Admin> getAllAdmin() {
        return adminServiceImplements.getAllAdmin();
    }

    @GetMapping("/getAdminById/{id}")
    public Admin getAdminById(@PathVariable("id") Long id) {
        return adminServiceImplements.getAdminById(id);
    }

    @GetMapping("/getAdminByEtat/{etat}")
    public List<Admin> getAdminByEtat(@PathVariable("etat") Etat etat) {
        return adminServiceImplements.getAdminByEtat(etat);
    }

    @GetMapping("/getAdninByType/{type}")
    public List<Admin> getAdminByType(@PathVariable("type") AdminEnum type) {
        return adminServiceImplements.getAdminByType(type);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminServiceImplements.deleteAdmin(id);
    }

    @GetMapping("/restaurerAdmin/{id}")
    public void restaurerAdmin(@PathVariable("id") Long id) {
        adminServiceImplements.restaurerAdmin(id);
    }

    @PutMapping("/modifierAdmin/{id}")
    @ResponseBody
    public Admin modifierAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
        return adminServiceImplements.modifierAdmin(id, admin);
    }

    @GetMapping("/authAdmin/{login}/{password}")
    @ResponseBody
    public Admin authAdmin(@PathVariable("login") String login_admin, @PathVariable("password")  String password_admin) {
        return adminServiceImplements.authAdmin(login_admin, password_admin);
    }

    @GetMapping("/nombreAdmin")
    public Integer nombreAdmin() {
        return adminServiceImplements.nombreAdmin();
    }

}
