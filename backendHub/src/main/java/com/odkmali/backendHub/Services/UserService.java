package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User>  getAllUser();
    public List<User> getUserByEtat(String etat);
    public User getUserById(Long id);
    public String modifierUser(Long id, User user);
    public void deleteUser(Long id);

}
