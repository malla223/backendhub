package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.CategorieService;
import com.odkmali.backendHub.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cat")
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @PostMapping("/saveCat")
    @ResponseBody
    public Categorie saveCat(@RequestBody Categorie cat) {
        return categorieService.saveCat(cat);
    }

    @GetMapping("/getAllCat")
    @ResponseBody
    public List<Categorie> getAllCat() {
        return categorieService.getAllCat();
    }

    @DeleteMapping("/deleteCat/{id}")
    public void deleteCat(@PathVariable("id") Long id) {
        categorieService.deleteCat(id);
    }

    @GetMapping("/getCatById/{id}")
    @ResponseBody
    public Categorie getCatById(@PathVariable("id") Long id) {
        return categorieService.getCatById(id);
    }

    @PutMapping("/modifierCat/{id}")
    @ResponseBody
    public Categorie modifierCat(@PathVariable("id") Long id, @RequestBody Categorie cat) {
        return categorieService.modifierCat(id, cat);
    }
}
