package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.Don;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.repository.DemandeDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeDonServiceImplements implements DemandeDonService{

    @Autowired
    DemandeDonRepo demandeDonRepo;

    public DemandeDon faireDemande(DemandeDon demandeDon) {
        Optional<DemandeDon> optionalDemandeDon = demandeDonRepo.findDemandeByDon(demandeDon.getUser(), demandeDon.getDon());

        if(optionalDemandeDon.isPresent()){
            System.out.println("Vous pouvez pas faire la demande du meme don");
        }else{
            demandeDonRepo.save(demandeDon);
        }
        return (demandeDon);
    }


    public List<DemandeDon> getDemandeDonAttente() {
        return demandeDonRepo.getDemandeDonAttente();
    }


    public List<DemandeDon> getDemandeConfirmer() {
        return demandeDonRepo.getDemandeConfirmer();
    }


    public void confirmerDemande(Long id) {
        demandeDonRepo.confirmerDemandeDon(id);
    }


    public void annulerDemande(Long id) {
        demandeDonRepo.annulerDemande(id);
    }

    public List<DemandeDon> getDemandeByUser(User user) {
        return demandeDonRepo.getDemandeDonByUser(user);
    }


    public DemandeDon getDemandeByid(Long id) {
        return demandeDonRepo.getDemandeAttenteById(id);
    }

}
