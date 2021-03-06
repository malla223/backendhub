package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.Ecole;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.repository.DemandeDonRepo;
import com.odkmali.backendHub.repository.DonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeDonServiceImplements implements DemandeDonService{

    @Autowired
    DemandeDonRepo demandeDonRepo;
    @Autowired
    DonRepo donRepo;

    public DemandeDon faireDemande(DemandeDon demandeDon) {
        Optional<DemandeDon> optionalDemandeDon = demandeDonRepo.findDemandeByDon(demandeDon.getUser(), demandeDon.getDon());

        if(optionalDemandeDon.isPresent()){
            System.out.println("Vous pouvez pas faire la demande du même don");
        }else{
            demandeDonRepo.save(demandeDon);
        }
        return (demandeDon);
    }


    public List<DemandeDon> getDemandeDonAttente() {
        return demandeDonRepo.getDemandeDonAttente();
    }

    public void confirmerDemande(Long id) {
        donRepo.demandeConfirmer(id);
        demandeDonRepo.confirmerDemandeDon(id);
    }

    public void annulerDemande(Long id) {
        demandeDonRepo.annulerDemande(id);
    }

    public List<DemandeDon> getDemandeByUser(User user) {
        return demandeDonRepo.getDemandeDonByUser(user);
    }

    public List<DemandeDon> getEleveByEcole(Ecole ecole) {
        return demandeDonRepo.getEleveByEcole(ecole);
    }


    public DemandeDon getDemandeByid(Long id) {
        return demandeDonRepo.getDemandeAttenteById(id);
    }

    public Integer nbreDemandeRecu() {
        return demandeDonRepo.nombreDonRecu();
    }

    public Integer nbreDemandeAttente() {
        return demandeDonRepo.nombreDemandeAttente();
    }

    public Integer nbreDemandeAttenteUser(User user) {
        return demandeDonRepo.nombreDemandeAttenteByUser(user);
    }

    public Integer nbreDemandeConfirmerUser(User user) {
        return demandeDonRepo.nombreDonRecuByUser(user);
    }

    public List<DemandeDon> getAllDemandeDon() {
        return demandeDonRepo.findAll();
    }

}
