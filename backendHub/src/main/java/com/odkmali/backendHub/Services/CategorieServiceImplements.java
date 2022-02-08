package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.Categorie;
import com.odkmali.backendHub.repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImplements implements CategorieService{

    @Autowired
    CategorieRepo categorieRepo;

    public Categorie saveCat(Categorie cat) {
        return categorieRepo.save(cat);
    }


    public List<Categorie> getAllCat() {
        return categorieRepo.findAll();
    }


    public void deleteCat(Long id) {
        categorieRepo.deleteById(id);
    }


    public Categorie getCatById(Long id) {
        return categorieRepo.findById(id).get();
    }

    public Categorie modifierCat(Long id, Categorie cat) {
        Categorie c = categorieRepo.findById(id).get();
        c.setLibelle_cat(cat.getLibelle_cat());
        return categorieRepo.save(cat);
    }
}
