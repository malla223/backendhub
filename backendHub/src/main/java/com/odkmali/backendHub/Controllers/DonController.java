package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.DonServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Don;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/don")
public class DonController {

    @Autowired
    DonServiceImplements donServiceImplements;

    @PostMapping("/saveDon")
    @ResponseBody
    public Don saveDon(@RequestBody Don don){
        return donServiceImplements.saveDon(don);
    }

    @GetMapping("/getDonConfirmer")
    @ResponseBody
    @CrossOrigin("*")
    public List<Don> getAllDonConfirmer(){
        return donServiceImplements.getAllDonConfirmer();
    }

    @GetMapping("/getDonAttente")
    @ResponseBody
    public List<Don> getAllDonAttente(){
        return donServiceImplements.getAllDonAttente();
    }

    @GetMapping("/getDonEncours")
    @ResponseBody
    public List<Don> getAllDonEncous(){
        return donServiceImplements.getAllDonEncous();
    }

    @GetMapping("/getDonEtat/{etat}")
    @ResponseBody
    public List<Don> getDonByEtat(@PathVariable("etat") Etat etat){
        return donServiceImplements.getDonByEtat(etat);
    }

    @GetMapping("/getDonId/{id}")
    @ResponseBody
    public Don getDonById(@PathVariable("id") Long id){
        return donServiceImplements.getDonById(id);
    }

    @PutMapping("/modifierDon/{id}")
    @ResponseBody
    public Don modifierDon(@PathVariable("id") Long id, @RequestBody Don don){
        return donServiceImplements.modifierDon(id, don);
    }

    @GetMapping("/annulerDon/{id}")
    public void annulerDon(@PathVariable("id") Long id){
        donServiceImplements.annulerDon(id);
    }

    @GetMapping("/confirmerDon/{id}")
    public void confirmerDon(@PathVariable("id") Long id){
        donServiceImplements.confirmerDon(id);
    }

    @GetMapping("/attenteDon/{id}")
    public void attenteDon(@PathVariable("id") Long id){
        donServiceImplements.attenteDon(id);
    }

    @GetMapping("/encoursDon/{id}")
    public void encoursDon(@PathVariable("id") Long id){
        donServiceImplements.encoursDon(id);
    }

    @DeleteMapping("/deleteDon/{id}")
    public void deleteDon(@PathVariable("id") Long id){
        donServiceImplements.deleteDon(id);
    }

}
