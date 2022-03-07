package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.EleveServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("api/eleve")
public class EleveController {

    @Autowired
    EleveServiceImplements eleveServiceImplements;

    @GetMapping("/getAllEleve")
    @ResponseBody
    public List<Eleve> getAllEleve(){
        return eleveServiceImplements.getAllEleve();
    }

    @GetMapping("/getEleveByEtat/{etat}")
    @ResponseBody
    public List<Eleve>getEleveByEtat(@PathVariable("etat") Etat etat){
        return eleveServiceImplements.getEleveByEtat(etat);
    }

    @GetMapping("/getEleveById/{id}")
    @ResponseBody
    public  Eleve getEleveById(@PathVariable("id") Long id){
        return eleveServiceImplements.getEleveById(id);
    }

    @DeleteMapping("/deleteEleve/{id}")
    public void deleteEleve(@PathVariable("id") Long id){
        eleveServiceImplements.deleteEleve(id);
    }
    @GetMapping("/restaurerEleve/{id}")
    @ResponseBody
    public void restaurerEleve(@PathVariable("id") Long id){
        eleveServiceImplements.restaurerEleve(id);
    }

    @PutMapping("/modifierEleve/{id}")
    @ResponseBody
    public Eleve modifierEleve (@PathVariable("id") Long id, @RequestBody Eleve eleve) {
        return eleveServiceImplements.modifierEleve(id, eleve);
    }

}
