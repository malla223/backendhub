package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.DemandeDonServiceImplements;
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

    @PostMapping("/demandeDon")
    @ResponseBody
    public DemandeDon faireDemande(@RequestBody DemandeDon demandeDon) {
        return demandeDonServiceImplements.faireDemande(demandeDon);
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

    @GetMapping("/getDemandeConfirmer")
    @ResponseBody
    public List<DemandeDon> getDemandeConfirmer() {
        return demandeDonServiceImplements.getDemandeConfirmer();
    }

    @GetMapping("/getAllDemande")
    @ResponseBody
    public List<DemandeDon> getAllDemandeDon() {
        return demandeDonServiceImplements.getAllDemandeDon();
    }

    @GetMapping("/confirmerD/{id}")
    public void confirmerDemande(@PathVariable("id") Long id) {
        demandeDonServiceImplements.confirmerDemande(id);
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
