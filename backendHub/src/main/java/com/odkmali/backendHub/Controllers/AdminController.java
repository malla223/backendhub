package com.odkmali.backendHub.Controllers;


import com.odkmali.backendHub.Services.AdminServiceImplements;
import com.odkmali.backendHub.enumeration.AdminEnum;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminServiceImplements adminServiceImplements;

    @PostMapping("/saveAdmin")
    @ResponseBody
    public Admin SaveAdmin(@RequestBody Admin admin){
        return adminServiceImplements.SaveAdmin(admin);
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

}
