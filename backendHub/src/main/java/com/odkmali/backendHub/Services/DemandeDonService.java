package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandeDonService {

    public DemandeDon faireDemande(DemandeDon demandeDon);
    public List<DemandeDon> getDemandeDonAttente();
    public List<DemandeDon> getDemandeConfirmer();
    public void confirmerDemande(Long id);
    public void annulerDemande(Long id);
    public List<DemandeDon> getDemandeByUser(User user);
    public DemandeDon getDemandeByid(Long id);
}
