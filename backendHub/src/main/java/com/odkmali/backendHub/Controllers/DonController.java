package com.odkmali.backendHub.Controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.odkmali.backendHub.SendEmail.EmailSendServivce;
import com.odkmali.backendHub.Services.DonServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Don;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.modelPhoto.FileUploadUtil;
import com.odkmali.backendHub.repository.DonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/don")
public class DonController {

    @Autowired
    DonServiceImplements donServiceImplements;
    @Autowired
    DonRepo donRepo;
    @Autowired
    EmailSendServivce emailSendServivce;

    @PostMapping("/saveDon")
    public Don saveDon(@RequestParam("data") String don, @RequestParam("image")MultipartFile photo)
            throws JsonParseException, JsonMappingException, Exception {

        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        Don d = new Don();
        d.setPhoto_don(fileName);

        Don savedon = donServiceImplements.saveDon(d, photo);
        String uploadDir = "src/main/resources/Images/Don" +savedon.getId_don();

        FileUploadUtil.saveFile(uploadDir, fileName, photo);

        return (d);
    }

    @GetMapping("/getDonConfirmer")
    @ResponseBody
    public List<Don> getAllDonConfirmer(){
        return donServiceImplements.getAllDonConfirmer();
    }


    @GetMapping("/getDonConfirmerPlateforme")
    @ResponseBody
    public List<Don> getAllDonConfirmerP(){
        return donRepo.getAllDonConfirmerPlateforme();
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
        Don d = donRepo.findById(id).get();
        if(d.getUser().getEmail_user() != null){
            if(d.getEtat() == Etat.inactif){
                emailSendServivce.envoyerEmail(d.getUser().getEmail_user(),
                        "Votre don a été annuler."+
                                "\n"+
                                "\n"+
                                "RAISON : "+
                                "\n"+
                                "En difficulté d'être en possession de votre livre physique, votre don a été annuler."+
                                "\n"+
                                "\n"+
                                "----INFO DON----"+
                                "\n"+
                                "\n"+
                                "Libellé don : "+d.getLibelle_don()+"\n"+
                                "Catégorie : " +d.getCategorie().getLibelle_cat()+"\n"+
                                "Niveau : "+d.getNiveau().getLibelle_niveau()+"\n"+
                                "\n"+
                                "\n"+
                                "En esperant plus de générosité de votre part, HUB SCOLAIRE vous dit MERCI.",
                        "Don Annuler"
                );
            }
        }
    }

    @GetMapping("/confirmerDon/{id}")
    public void confirmerDon(@PathVariable("id") Long id){
        donServiceImplements.confirmerDon(id);
        Don d = donRepo.findById(id).get();
        if(d.getUser().getEmail_user() != null){
            if(d.getEtat() == Etat.confirmer){
                emailSendServivce.envoyerEmail(d.getUser().getEmail_user(),
                        "Votre don a été confirmer."+
                        "\n"+
                        "Elle est maintenant disponible sur la plateforme."+
                        "\n"+
                        "\n"+
                        "----INFO DON----"+
                        "\n"+
                                "\n"+
                        "Libellé don : "+d.getLibelle_don()+"\n"+
                        "Catégorie : " +d.getCategorie().getLibelle_cat()+"\n"+
                        "Niveau : "+d.getNiveau().getLibelle_niveau()+"\n"+
                                "\n"+
                                "\n"+
                                "MERCI de votre générosité.",
                        "Don Confirmer"
                        );
            }
        }
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

    @GetMapping("/getDonByUser/{id_user}")
    @ResponseBody
    public List<Don> getDonByUser(@PathVariable("id_user") User user) {
        return donServiceImplements.getDonByUser(user);
    }

    @GetMapping(value = "/getPhoto/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {
        return donServiceImplements.getPhoto(id);
    }

    @GetMapping("/nbreDonC")
    public Integer nbreDonC() {
        return donServiceImplements.nbreDonC();
    }

    @GetMapping("/nbreDonA")
    public Integer nbreDonA() {
        return donServiceImplements.nbreDonA();
    }

    @GetMapping("/nbreDonAttente/{user}")
    public Integer nbreDonAttenteUser(@PathVariable("user") User user) {
        return donRepo.nombreDonAttenteByUser(user);
    }

}
