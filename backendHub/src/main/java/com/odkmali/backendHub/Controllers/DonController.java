package com.odkmali.backendHub.Controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.odkmali.backendHub.Services.DonServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Don;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.modelPhoto.FileUploadUtil;
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

    @PostMapping("/saveDon")
    public Don saveDon(@RequestParam("data") String don, @RequestParam("image")MultipartFile photo)
            throws JsonParseException, JsonMappingException, Exception {

        String fileName = StringUtils.cleanPath(photo.getOriginalFilename());
        Don d = new Don();
        d.setPhoto_don(fileName);

        Don savedon = donServiceImplements.saveDon(d, photo);
        String uploadDir = "src/main/resources/Images/" +savedon.getId_don();

        FileUploadUtil.saveFile(uploadDir, fileName, photo);

        return (d);
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

}
