package com.odkmali.backendHub.Services;


import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Eleve;
import com.odkmali.backendHub.repository.EleveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EleveServiceImplements {

    @Autowired
    EleveRepo eleveRepo;

    public List<Eleve> getAllEleve(){
        return eleveRepo.getAllEleve();
    }

    public List<Eleve>getEleveByEtat(Etat etat){
        return eleveRepo.getEleveByEtat(etat);
    }

    public  Eleve getEleveById(Long id){
        return eleveRepo.getEleveById(id);
    }

    public void deleteEleve(Long id){
        eleveRepo.deleteEleve(id);
    }
    public void restaurerEleve(Long id){
        eleveRepo.restaurerEleve(id);
    }

    public Eleve modifierEleve (Long id,Eleve eleve) {
        Eleve e = eleveRepo.findById(id).get();
        e.setNom_eleve(eleve.getNom_eleve());
        e.setPrenom_eleve(eleve.getPrenom_eleve());
        e.setClasse_eleve(eleve.getClasse_eleve());
        e.setNomcomplet_parent(eleve.getNomcomplet_parent());
        e.setContact_parent(eleve.getContact_parent());
        e.setEcole(eleve.getEcole());
        return eleveRepo.save(e);
    }
}
