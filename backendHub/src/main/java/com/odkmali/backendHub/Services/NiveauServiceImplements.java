package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.Niveau;
import com.odkmali.backendHub.repository.NiveauRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauServiceImplements implements NiveauService{

    @Autowired
    NiveauRepo niveauRepo;

    @Override
    public Niveau saveNiveau(Niveau niveau) {
        return niveauRepo.save(niveau);
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
        return niveauRepo.save(niveau);
    }
}
