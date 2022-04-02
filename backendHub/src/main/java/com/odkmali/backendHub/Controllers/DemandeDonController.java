package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.SendEmail.EmailSendServivce;
import com.odkmali.backendHub.Services.DemandeDonServiceImplements;
import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.enumeration.TypeUser;
import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.Ecole;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.repository.DemandeDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/don")
public class DemandeDonController {

    @Autowired
    DemandeDonServiceImplements demandeDonServiceImplements;
    @Autowired
    DemandeDonRepo demandeDonRepo;
    @Autowired
    EmailSendServivce emailSendServivce;

    @PostMapping("/demandeDonE")
    @ResponseBody
    public DemandeDon demandeEcole(@RequestBody DemandeDon demandeDon){
        demandeDonServiceImplements.faireDemande(demandeDon);
        if(demandeDon.getEcole().getType() == TypeUser.ecole){
            if(demandeDon.getEcole().getEmail_ecole() != null){
                if(demandeDon.getEtat() == Etat.attente){
                    emailSendServivce.envoyerEmail(demandeDon.getEcole().getEmail_ecole(),
                            "Votre demande de don a été éffectué avec succès"+
                                    "\n" +
                                    "\n" +
                                    "\n" + "Votre demande est placé sur une liste d'attente."+
                                    "\n"+
                                    "\n" +
                                    "Si dans cinq (5) jours vous n'avez pas été contacter, considerez que le don a été attribué à un autre utilisateur."+
                                    "\n" +
                                    "\n" +
                                    "\n" + "MERCI DE VOTRE COMPREHENSION." ,
                            "Demande de don");
                }
            }
        }
        return  demandeDon;
    }


    @PostMapping("/demandeDon")
    @ResponseBody
    public DemandeDon faireDemande(@RequestBody DemandeDon demandeDon) {
        demandeDonServiceImplements.faireDemande(demandeDon);
        if(demandeDon.getUser().getType() == TypeUser.user){
            if(demandeDon.getUser().getEmail_user() != null){
                if(demandeDon.getEtat() == Etat.attente){
                    emailSendServivce.envoyerEmail(demandeDon.getUser().getEmail_user(),
                            "Votre demande de don a été éffectué avec succès"+
                                    "\n" +
                                    "\n" +
                                    "\n" + "Votre demande est placé sur une liste d'attente."+
                                    "\n"+
                                    "\n" +
                                    "Si dans cinq (5) jours vous n'avez pas été contacter, considerez que le don a été attribué à un autre utilisateur."+
                                    "\n" +
                                    "\n" +
                                    "\n" + "MERCI DE VOTRE COMPREHENSION." ,
                            "Demande de don");
                }
            }
        }
        return demandeDon;
    }

    @GetMapping("/getDemandeAttente")
    @ResponseBody
    public List<DemandeDon> getDemandeDonAttente() {
        return demandeDonServiceImplements.getDemandeDonAttente();
    }


    @GetMapping("/getDemandeAttenteEcole")
    @ResponseBody
    public List<DemandeDon> getDemandeDonEcoleAttente() {
        return demandeDonRepo.getDemandeDonEcoleAttente();
    }

    @GetMapping("/getDemandeConfirmerEcole")
    @ResponseBody
    public List<DemandeDon> getDemandeConfirmer() {
        return demandeDonRepo.getDemandeConfirmerEcole();
    }

    @GetMapping("/getDemandeConfirmerUser")
    @ResponseBody
    public List<DemandeDon> getDemandeConfirmerUser() {
        return demandeDonRepo.getDemandeConfirmerUser();
    }

    @GetMapping("/getAllDemande")
    @ResponseBody
    public List<DemandeDon> getAllDemandeDon() {
        return demandeDonServiceImplements.getAllDemandeDon();
    }

    @GetMapping("/confirmerDonEcole/{id}")
    public void confirmerDemandeEcole(@PathVariable("id") Long id){
        demandeDonServiceImplements.confirmerDemande(id);
        DemandeDon d = demandeDonRepo.findById(id).get();
        if(d.getEcole().getEmail_ecole() != null){
            if(d.getEtat() == Etat.confirmer){
                emailSendServivce.envoyerEmail(d.getEcole().getEmail_ecole(),
                        "Votre demande de don a été confirmer." +
                                "\n"+
                                "Votre don sera livré dans deux (2) jours."+
                                "\n"+
                                "\n"+
                                "-------DETAILS ETABLISSEMENT-------"+
                                "\n"+
                                "Etablissement : "+ d.getEcole().getNom_ecole()+
                                "\n"+
                                "Contact établissement :"+d.getEcole().getTel_ecole()+
                                "\n"+
                                "\n"+
                                "-------DETAIL DON-------"+
                                "\n"+
                                "Libéllé don : "+d.getDon().getLibelle_don()+
                                "\n"+
                                "Niveau : "+d.getDon().getNiveau().getLibelle_niveau()+
                                "\n"+
                                "Catégorie : "+d.getDon().getCategorie().getLibelle_cat()+
                                "\n"+
                                "Demande fait le : "+d.getDate()+
                                "\n"+
                                "\n"+
                                "-------INFO PARENTS-------"+
                                "\n"+
                                "Nom complet du parent : "+d.getNom_parent()+
                                "\n"+
                                "Contact du parent : "+d.getTel_parent()+
                                "\n"+
                                "\n"+
                                "MERCI DE VOTRE PATIENCE.","Demande Confirmer");
            }
        }
    }

    @GetMapping("/confirmerD/{id}")
    public void confirmerDemande(@PathVariable("id") Long id) {
        demandeDonServiceImplements.confirmerDemande(id);
        DemandeDon d = demandeDonRepo.findById(id).get();
        if(d.getUser().getType() == TypeUser.user){
            if(d.getUser().getEmail_user() != null){
                if(d.getEtat() == Etat.confirmer){
                    emailSendServivce.envoyerEmail(d.getUser().getEmail_user(),
                            "Votre demande de don a été confirmer." +
                                    "\n"+
                                    "Votre don sera livré à votre établissement dans deux (2) jours."+
                                    "\n"+
                                    "\n"+
                                    "-------DETAILS ETABLISSEMENT-------"+
                                    "\n"+
                                    "Etablissement : "+ d.getNom_ecole()+
                                    "\n"+
                                    "Contact établissement :"+d.getTel_ecole()+
                                    "\n"+
                                    "\n"+
                                    "\n"+
                                    "-------DETAILS DON-------"+
                                    "\n"+
                                    "Libéllé don : "+d.getDon().getLibelle_don()+
                                    "\n"+
                                    "Niveau : "+d.getDon().getNiveau().getLibelle_niveau()+
                                    "\n"+
                                    "Catégorie : "+d.getDon().getCategorie().getLibelle_cat()+
                                    "\n"+
                                    "Demande fait le : "+d.getDate()+
                                    "\n"+
                                    "\n"+
                                    "\n"+
                                    "MERCI DE VOTRE PATIENCE.","Demande Confirmer");
                }
            }
        }

    }

    @GetMapping("/annulerD/{id}")
    public void annulerDemande(@PathVariable("id") Long id) {
        demandeDonServiceImplements.annulerDemande(id);
    }

    @GetMapping("/getAllDemandeUser/{id_user}")
    @ResponseBody
    public List<DemandeDon> getDemandeByUser(@PathVariable("id_user") User user) {
        return demandeDonServiceImplements.getDemandeByUser(user);
    }

    @GetMapping("/getAllDemandeEcole/{id_ecole}")
    @ResponseBody
    public List<DemandeDon> getDemandeByEcole(@PathVariable("id_ecole") Ecole ecole) {
        return demandeDonRepo.getDemandeDonByEcole(ecole);
    }

    @GetMapping("/getAllEleveEcole/{id_ecole}")
    @ResponseBody
    public List<DemandeDon> getEleveByEcole(@PathVariable("id_ecole") Ecole ecole) {
        return demandeDonServiceImplements.getEleveByEcole(ecole);
    }

    @GetMapping("/getDemandeById/{id}")
    @ResponseBody
    public DemandeDon getDemandeByid(@PathVariable("id") Long id) {
        return demandeDonServiceImplements.getDemandeByid(id);
    }

    @GetMapping("/nbreDonRecu")
    public Integer nbreDemandeRecu() {
        return demandeDonServiceImplements.nbreDemandeRecu();
    }

    @GetMapping("/nbreDonAttente")
    public Integer nbreDemandeAttente() {
        return demandeDonServiceImplements.nbreDemandeAttente();
    }

    @GetMapping("/nbreDemandeAttente/{user}")
    public Integer nbreDemandeAttenteUser(@PathVariable("user") User user) {
        return demandeDonServiceImplements.nbreDemandeAttenteUser(user);
    }

    @GetMapping("/nbreDonRecu/{user}")
    public Integer nbreDemandeConfirmerUser(@PathVariable("user") User user) {
        return demandeDonServiceImplements.nbreDemandeConfirmerUser(user);
    }

    @GetMapping("/nbreDemandeAttenteEcole/{ecole}")
    public Integer nbreDemandeAttenteEcole(@PathVariable("ecole") Ecole ecole) {
        return demandeDonRepo.nombreDemandeAttenteByEcole(ecole);
    }

    @GetMapping("/nbreDonRecuEcole/{ecole}")
    public Integer nbreDemandeConfirmerEcole(@PathVariable("ecole") Ecole ecole) {
        return demandeDonRepo.nombreDonRecuByEcole(ecole);
    }

}
