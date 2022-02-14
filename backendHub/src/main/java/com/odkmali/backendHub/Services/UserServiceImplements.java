package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplements implements UserService{

    @Autowired
    UserRepo userRepo;

    public User createUser(User user, @RequestParam("image") MultipartFile photo) throws IOException{
        Optional<User> optionalUser = this.userRepo.findUser(user.getLogin_user());

        if(optionalUser.isPresent())
        {System.out.println("Ce compte existe déjà, changer votre Login " + user.getLogin_user());
        }else{
            userRepo.save(user);
        }
        return (user);
    }

    public List<User> getAllUser() {
        return userRepo.getAllUser();
    }


    public List<User> getUserByEtat(Etat etat) {
        return userRepo.getAllUserByEtat(etat);
    }


    public User getUserById(Long id) {
        return userRepo.getUserById(id);
    }

    public User modifierUser(Long id, User user) {
        User u = userRepo.findById(id).get();
        u.setNom_complet(user.getNom_complet());
        u.setLogin_user(user.getLogin_user());
        u.setAdresse_user(user.getAdresse_user());
        u.setTel_user(user.getTel_user());
        u.setPassword_user(user.getPassword_user());
        u.setPhoto_user(user.getPhoto_user());
        return userRepo.save(u);
    }


    public void deleteUser(Long id) {
        userRepo.deleteUser(id);
    }

    public void restaurerUser(Long id) {
        userRepo.restaurerUser(id);
    }

    public User authUser(String login, String password) {
        return userRepo.getUserByLoginAndPassword(login, password);
    }


    public byte[] getPhoto(Long id) throws IOException {
        User u = userRepo.getUserById(id);
        String iconPhoto = u.getPhoto_user();
        File file = new File ("src/main/resources/Images/" + u.getId_user() + "/" + iconPhoto);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
}
