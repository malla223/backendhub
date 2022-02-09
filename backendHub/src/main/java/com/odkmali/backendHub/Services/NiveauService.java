package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.Categorie;
import com.odkmali.backendHub.model.Niveau;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NiveauService {
    public Niveau saveNiveau(Niveau niveau);
    public List<Niveau> getAllNiveau();
    void deleteNiveau(Long id);
    public Niveau getNiveauById(Long id);
    public Niveau modifierNiveau(Long id, Niveau niveau);
}
