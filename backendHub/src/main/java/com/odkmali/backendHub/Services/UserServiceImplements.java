package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplements implements UserService{

    @Autowired
    UserRepo userRepo;

    public User createUser(User user) {
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
        return userRepo.findById(id).get();
    }

    public User modifierUser(Long id, User user) {
        User u = userRepo.findById(id).get();
        u.setNom_user(user.getNom_user());
        u.setPrenom_user(user.getPrenom_user());
        u.setLogin_user(user.getLogin_user());
        u.setAdresse_user(user.getAdresse_user());
        u.setTel_user(user.getTel_user());
        u.setPhoto_user(user.getPhoto_user());
        return userRepo.save(user);
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
}
