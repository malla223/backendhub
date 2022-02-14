package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.User;
import com.odkmali.backendHub.repository.DemandeDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeDonServiceImplements implements DemandeDonService{

    @Autowired
    DemandeDonRepo demandeDonRepo;

    public DemandeDon faireDemande(DemandeDon demandeDon) {
        return demandeDonRepo.save(demandeDon);
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
}
