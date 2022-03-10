package com.odkmali.backendHub.Services;


import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Ecole;
import com.odkmali.backendHub.repository.EcoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class EcoleServiceImplements implements EcoleService{

    @Autowired
    EcoleRepo ecoleRepo;

    public List<Ecole> getEcoleByEtat(Etat etat){return ecoleRepo.getEcoleByEtat(etat);}

    public List<Ecole> getAllEcole(){return ecoleRepo.getAllEcole();}

    public void deleteEcole (Long id){ecoleRepo.deleteEcole(id);}

    public void restaurerEcole (Long id){ecoleRepo.restaurerEcole(id);}

    public Ecole getEcoleById(Long id){return ecoleRepo.getEcoleById(id);}

    public Ecole saveEcole(Ecole ecole, MultipartFile contrat) throws IOException {
        Optional<Ecole> optionalEcole = ecoleRepo.findEcole(ecole.getLogin_ecole());
        if(optionalEcole.isPresent()){
            System.out.println("Ce login est déjà designé a un ecole");
        }else{
            ecoleRepo.save(ecole);
        }
        return (ecole);
    }

    public Ecole modifierEcole(Long id, Ecole ecole) {
        Ecole e = ecoleRepo.findById(id).get();
        e.setNom_ecole(ecole.getNom_ecole());
        e.setEtat(ecole.getEtat());
        e.setLogin_ecole(ecole.getLogin_ecole());
        e.setPassword_ecole(ecole.getPassword_ecole());
        e.setSite_ecole(ecole.getSite_ecole());
        e.setTel_ecole(ecole.getTel_ecole());
        e.setContrat_ecole(ecole.getContrat_ecole());
        e.setAdresse_ecole(ecole.getAdresse_ecole());
        e.setEmail_ecole(ecole.getEmail_ecole());
        return ecoleRepo.save(e);
    }

    @Override
    public Ecole authEcole(String login, String password) {
        return ecoleRepo.getEcoleByLoginAndPassword(login, password);
    }
}
