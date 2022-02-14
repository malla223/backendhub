package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface UserService {

    public User createUser(User user, MultipartFile photo) throws  IOException;
    public List<User> getAllUser();
    public List<User> getUserByEtat(Etat etat);
    public User getUserById(Long id);
    public User modifierUser(Long id, User user);
    void deleteUser(Long id);
    void restaurerUser(Long id);
    User authUser(String login, String password);
    public byte[] getPhoto(Long id) throws IOException;

}
