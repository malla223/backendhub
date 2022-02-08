package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.Don;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonService {

    public Don saveDon(Don don);
    public List<Don> getAllDon();
    public List<Don> getAllDonConfirmer();
    public List<Don> getAllDonInactif();
    public List<Don> getAllDonAttente();
    public List<Don> getAllDonEncous();
    public List<Don> getDonByEtat(String etat);
    public Don getDonById(Long id);
    public Don modifierDon(Long id, Don don);
    void deleteDon(Long id);
    public Don restaurerDon(Long id);
 }
