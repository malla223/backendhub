package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.model.Ecole;
import com.odkmali.backendHub.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface DemandeDonService {

    public DemandeDon faireDemande(DemandeDon demandeDon);
    public List<DemandeDon> getDemandeDonAttente();
    public void confirmerDemande(Long id);
    public void annulerDemande(Long id);
    public List<DemandeDon> getDemandeByUser(User user);
    public List<DemandeDon> getEleveByEcole(Ecole ecole);
    public DemandeDon getDemandeByid(Long id);
    public Integer nbreDemandeRecu();
    public Integer nbreDemandeAttente();
    public Integer nbreDemandeAttenteUser(User user);
    public Integer nbreDemandeConfirmerUser(User user);
    public List<DemandeDon> getAllDemandeDon();
}
