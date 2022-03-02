package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.EcoleServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Ecole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ecole")
public class EcoleContoller {

    @Autowired
    EcoleServiceImplements   ecoleServiceImplements;

    @PostMapping("/saveEcole")
    @ResponseBody
    public Ecole saveEcole(@RequestBody Ecole ecole){
        return ecoleServiceImplements.saveEcole(ecole);
    }

    @GetMapping("/getEcoleByEtat/{etat}")
    @ResponseBody
    public List<Ecole> getEcoleByEtat(@PathVariable("etat") Etat etat){
        return ecoleServiceImplements.getEcoleByEtat(etat);}

    @GetMapping("/getAllEcole")
    @ResponseBody
    public List<Ecole> getAllEcole() {
        return ecoleServiceImplements.getAllEcole();
    }

    @DeleteMapping("/deleteEcole/{id}")
    public void deleteEcole (@PathVariable("id") Long id){
        ecoleServiceImplements.deleteEcole(id);}

    @GetMapping("/restaurerEcole/{id}")
    @ResponseBody
    public void restaurerEcole (@PathVariable("id") Long id){
        ecoleServiceImplements.restaurerEcole(id);}

    @GetMapping("/getEcoleById/{id}")
    public Ecole getEcoleById(@PathVariable("id") Long id){
        return ecoleServiceImplements.getEcoleById(id);}

        @PutMapping("/modifierEccole/{id}")
    @ResponseBody
    public Ecole modifierEcole(@PathVariable("id") Long id, @RequestBody Ecole ecole) {
        return ecoleServiceImplements.modifierEcole(id, ecole);}
}
