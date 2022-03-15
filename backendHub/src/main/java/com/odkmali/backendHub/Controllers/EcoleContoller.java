package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.EcoleServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Ecole;
import com.odkmali.backendHub.modelPhoto.FileUploadUtil;
import com.odkmali.backendHub.repository.EcoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ecole")
public class EcoleContoller {

    @Autowired
    EcoleServiceImplements   ecoleServiceImplements;
    @Autowired
    EcoleRepo ecoleRepo;

    @PostMapping("/saveEcole")
    @ResponseBody
    public Ecole saveEcole(@RequestParam("data") String ecole, @RequestParam("contrat")MultipartFile contrat)
    throws Exception {
        String fileName = StringUtils.cleanPath(contrat.getOriginalFilename());
        Ecole e = new Ecole();
        e.setContrat_ecole(fileName);

        Ecole saveEcole = ecoleServiceImplements.saveEcole(e, contrat);
        String uploadDir = "src/main/resources/Contrat/Ecole/" +saveEcole.getId_ecole();

        FileUploadUtil.saveFile(uploadDir, fileName, contrat);

        return (e);
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

    @GetMapping("/getAllEcoleAttente")
    @ResponseBody
    public List<Ecole> getAllEcoleAttente() {
        return ecoleRepo.getAllEcoleAttente();
    }

    @DeleteMapping("/deleteEcole/{id}")
    public void deleteEcole (@PathVariable("id") Long id){
        ecoleServiceImplements.deleteEcole(id);}

    @GetMapping("/restaurerEcole/{id}")
    @ResponseBody
    public void restaurerEcole (@PathVariable("id") Long id){
        ecoleServiceImplements.restaurerEcole(id);
    }

    @GetMapping("/getEcoleById/{id}")
    public Ecole getEcoleById(@PathVariable("id") Long id){
        return ecoleServiceImplements.getEcoleById(id);}

        @PutMapping("/modifierEccole/{id}")
    @ResponseBody
    public Ecole modifierEcole(@PathVariable("id") Long id, @RequestBody Ecole ecole) {
        return ecoleServiceImplements.modifierEcole(id, ecole);}

    @GetMapping("/auth/{login}/{password}")
    public Ecole authUser(@PathVariable String login, @PathVariable String password) {
        return ecoleServiceImplements.authEcole(login, password);
    }
}
