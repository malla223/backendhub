package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Ecole;
import com.odkmali.backendHub.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;
import java.util.List;

@Service
public interface EcoleService {

    public List<Ecole> getEcoleByEtat(Etat etat);
    public List<Ecole> getAllEcole();
    public void deleteEcole (Long id);
    public void restaurerEcole (Long id);
    public Ecole getEcoleById(Long id);
    public Ecole saveEcole(Ecole ecole, MultipartFile contrat) throws AddressException, MessagingException, IOException;
    public Ecole modifierEcole(Long id , Ecole ecole);
    Ecole authEcole(String login, String password);
}
