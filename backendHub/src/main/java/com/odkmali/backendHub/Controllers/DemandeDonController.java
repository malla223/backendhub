package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.DemandeDonServiceImplements;
import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/don")
public class DemandeDonController {

    @Autowired
    DemandeDonServiceImplements demandeDonServiceImplements;

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

    @GetMapping("/getDemandeConfirmer")
    @ResponseBody
    public List<DemandeDon> getDemandeConfirmer() {
        return demandeDonServiceImplements.getDemandeConfirmer();
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

    @GetMapping("/getDemandeById/{id}")
    @ResponseBody
    public DemandeDon getDemandeByid(@PathVariable("id") Long id) {
        return demandeDonServiceImplements.getDemandeByid(id);
    }
}
