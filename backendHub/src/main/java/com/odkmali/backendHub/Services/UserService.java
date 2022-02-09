package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);
    public List<User> getAllUser();
    public List<User> getUserByEtat(Etat etat);
    public User getUserById(Long id);
    public User modifierUser(Long id, User user);
    void deleteUser(Long id);
    void restaurerUser(Long id);

}
