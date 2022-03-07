package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.Niveau;
import com.odkmali.backendHub.repository.NiveauRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauServiceImplements implements NiveauService{

    @Autowired
    NiveauRepo niveauRepo;

    @Override
    public Niveau saveNiveau(Niveau niveau) {
        Optional<Niveau> optNiveau = niveauRepo.findNiveau(niveau.getLibelle_niveau());
        if(optNiveau.isPresent()){
            System.out.println("Ce niveau existe déjà");
        }else{
            niveauRepo.save(niveau);
        }
        return (niveau);
    }

    @Override
    public List<Niveau> getAllNiveau() {
        return niveauRepo.findAll();
    }

    @Override
    public void deleteNiveau(Long id) {
        niveauRepo.deleteById(id);
    }

    @Override
    public Niveau getNiveauById(Long id) {
        return niveauRepo.findById(id).get();
    }

    @Override
    public Niveau modifierNiveau(Long id, Niveau niveau) {
        Niveau n = niveauRepo.findById(id).get();
        n.setLibelle_niveau(niveau.getLibelle_niveau());
        return niveauRepo.save(n);
    }

    @Override
    public Niveau getNiveauByLibelle(String libelle) {
        return niveauRepo.getByNiveau(libelle);
    }
}
