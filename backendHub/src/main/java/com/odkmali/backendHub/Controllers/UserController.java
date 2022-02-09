package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.UserServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImplements userServiceImplements;

    @PostMapping("/saveUser")
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userServiceImplements.createUser(user);
    }

    @GetMapping("/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        return userServiceImplements.getAllUser();
    }

    @GetMapping("/getUserByEtat/{etat}")
    @ResponseBody
    public List<User> getUserByEtat(@PathVariable("etat") Etat etat) {
        return userServiceImplements.getUserByEtat(etat);
    }

    @GetMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id) {
        return userServiceImplements.getUserById(id);
    }

    @PutMapping("/modifierUser/{id}")
    @ResponseBody
    public User modifierUser(@PathVariable("id") Long id, @RequestBody User user) {
        return userServiceImplements.modifierUser(id, user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userServiceImplements.deleteUser(id);
    }

    @GetMapping("/restaurer/{id}")
    @ResponseBody
    public void restaurerUser(@PathVariable("id") Long id) {
        userServiceImplements.restaurerUser(id);
    }
}
