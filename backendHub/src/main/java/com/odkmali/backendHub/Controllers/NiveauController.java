package com.odkmali.backendHub.Controllers;


import com.odkmali.backendHub.Services.NiveauServiceImplements;
import com.odkmali.backendHub.model.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/niveau")
public class NiveauController {

    @Autowired
    NiveauServiceImplements niveauServiceImplements;

    @PostMapping("/saveNiveau")
    @ResponseBody
    public Niveau saveNiveau(@RequestBody Niveau niveau){
        return niveauServiceImplements.saveNiveau(niveau);
    }

    @GetMapping("/getAllNiveau")
    @ResponseBody
    public List<Niveau> getAllNiveau(){
        return niveauServiceImplements.getAllNiveau();
    }

    @DeleteMapping("/deleteNiveau/{id}")
    void deleteNiveau(@PathVariable("id") Long id){
        niveauServiceImplements.deleteNiveau(id);
    }

    @GetMapping("/getNiveauId/{id}")
    @ResponseBody
    public Niveau getNiveauById(@PathVariable("id") Long id){
        return niveauServiceImplements.getNiveauById(id);
    }

    @PutMapping("/modifierNiveau/{id}")
    @ResponseBody
    public Niveau modifierNiveau(@PathVariable("id") Long id, @RequestBody Niveau niveau){
        return niveauServiceImplements.modifierNiveau(id, niveau);
    }
}
