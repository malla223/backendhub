package com.odkmali.backendHub.Controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.odkmali.backendHub.Services.UserServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.modelPhoto.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImplements userServiceImplements;

    @PostMapping("/saveUser")
    public User createUser(@RequestParam("data") String user , @RequestParam("image")MultipartFile photo)
            throws JsonParseException, JsonMappingException, Exception {

        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        User u = new User();
        u.setPhoto_user(fileName);

        User saveuser = userServiceImplements.createUser(u, photo);
        String uploadDir = "src/main/resources/Images/" +saveuser.getId_user();

        FileUploadUtil.saveFile(uploadDir, fileName, photo);

        return (u);
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

    @GetMapping("/auth/{login}/{password}")
    public User authUser(@PathVariable String login, @PathVariable String password) {
        return userServiceImplements.authUser(login, password);
    }

    @GetMapping(value = "/getPhoto/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
        return userServiceImplements.getPhoto(id);
    }

    @GetMapping("/nombreUser")
    public Integer nbreUser() {
        return userServiceImplements.nbreUser();
    }
}
