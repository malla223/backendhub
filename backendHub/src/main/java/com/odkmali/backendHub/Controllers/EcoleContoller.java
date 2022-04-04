package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.SendEmail.EmailSendServivce;
import com.odkmali.backendHub.Services.EcoleServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Ecole;
import com.odkmali.backendHub.modelPhoto.FileUploadUtil;
import com.odkmali.backendHub.repository.EcoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ecole")
public class EcoleContoller {

    @Autowired
    EcoleServiceImplements   ecoleServiceImplements;
    @Autowired
    EcoleRepo ecoleRepo;
    @Autowired
    EmailSendServivce emailSendServivce;

    @PostMapping("/saveEcole")
    @ResponseBody
    public Ecole saveEcole(@RequestParam("data") String ecole, @RequestParam("contrat")MultipartFile contrat)
    throws Exception {
        String fileName = StringUtils.cleanPath(contrat.getOriginalFilename());
        Ecole e = new Ecole();
        e.setContrat_ecole(fileName);

        Ecole saveEcole = ecoleServiceImplements.saveEcole(e, contrat);
        String uploadDir = "src/main/resources/Contrat/Ecole/" +saveEcole;

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

    @GetMapping("/inactiver/{id}")
    public void inactiver (@PathVariable("id") Long id){
        ecoleRepo.deleteEcole(id);
        Ecole e = ecoleRepo.findById(id).get();
        if(e.getEmail_ecole() != null){
            if(e.getEtat() == Etat.inactif){
                emailSendServivce.envoyerEmail(e.getEmail_ecole(),
                        "Votre compte a été desactiver."+
                                "\n"+
                                "\n"+"Votre contrat n'est pas conforme au règlement."+
                                "\n"+
                                "\n"+ "MERCI de fournir un contrat valide.",
                        "Compte Inactiver");
            }
        }
    }

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

    @GetMapping(value = "/getPdf/{id}", produces = { MediaType.APPLICATION_PDF_VALUE})
    public byte[] getPdf(@PathVariable("id") Long id) throws IOException {
        return ecoleServiceImplements.getPdf(id);
    }
}
