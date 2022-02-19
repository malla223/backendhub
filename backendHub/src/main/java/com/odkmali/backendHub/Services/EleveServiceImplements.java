package com.odkmali.backendHub.Services;


import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Eleve;
import com.odkmali.backendHub.repository.EleveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EleveServiceImplements implements EleveService{

    @Autowired
    EleveRepo eleveRepo;

    @Override
    public List<Eleve> getEleveByEtat(Etat etat) {
        return eleveRepo.getEleveByEtat(etat);
    }

    @Override
    public Eleve getEleveById(Long id) {
        return eleveRepo.getEleveById(id);
    }

    @Override
    public List<Eleve> getAllEleve() {
        return eleveRepo.getAllEleve();
    }

    @Override
    public void deleteEleve(Long id) {
        eleveRepo.deleteEleve(id);
    }

    @Override
    public void restaurerEleve(Long id) {
        eleveRepo.restaurerEleve(id);
    }

    @Override
    public Eleve saveEleve(Eleve eleve) {
        return eleveRepo.save(eleve);
    }

    @Override
    public Eleve modifierEleve(Long id, Eleve eleve) {
        Eleve e = eleveRepo.getEleveById(id);
        e.setNom_eleve(eleve.getNom_eleve());
        e.setClasse_eleve(eleve.getClasse_eleve());
        e.setPrenom_eleve(eleve.getPrenom_eleve());
        e.setEcole(eleve.getEcole());
        e.setContact_parent(eleve.getContact_parent());
        e.setNomcomplet_parent(eleve.getNomcomplet_parent());
        return eleveRepo.save(e);
    }
}
