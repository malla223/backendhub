package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategorieService {

    public Categorie saveCat(Categorie cat);
    public List<Categorie> getAllCat();
    void deleteCat(Long id);
    public Categorie getCatById(Long id);
    public Categorie modifierCat(Long id, Categorie cat);
}
