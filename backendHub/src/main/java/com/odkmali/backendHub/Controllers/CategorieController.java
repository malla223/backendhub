package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.CategorieService;
import com.odkmali.backendHub.Services.CategorieServiceImplements;
import com.odkmali.backendHub.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cat")
public class CategorieController {

    @Autowired
    CategorieServiceImplements categorieServiceImplements;

    @PostMapping("/saveCat")
    @ResponseBody
    public Categorie saveCat(@RequestBody Categorie cat) {
        return categorieServiceImplements.saveCat(cat);
    }

    @GetMapping("/getAllCat")
    @ResponseBody
    public List<Categorie> getAllCat() {
        return categorieServiceImplements.getAllCat();
    }

    @DeleteMapping("/deleteCat/{id}")
    public void deleteCat(@PathVariable("id") Long id) {
        categorieServiceImplements.deleteCat(id);
    }

    @GetMapping("/getCatById/{id}")
    @ResponseBody
    public Categorie getCatById(@PathVariable("id") Long id) {
        return categorieServiceImplements.getCatById(id);
    }

    @PutMapping("/modifierCat/{id}")
    @ResponseBody
    public Categorie modifierCat(@PathVariable("id") Long id, @RequestBody Categorie cat) {
        return categorieServiceImplements.modifierCat(id, cat);
    }

    @GetMapping("/getCatByLibelle/{libelle}")
    @ResponseBody
    public Categorie getCatByLib(@PathVariable("libelle") String libelle) {
        return categorieServiceImplements.getCatByLib(libelle);
    }
}
