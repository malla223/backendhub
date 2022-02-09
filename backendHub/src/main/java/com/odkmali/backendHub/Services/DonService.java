package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Don;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonService {

    public Don saveDon(Don don);
    public List<Don> getAllDonConfirmer();
    public List<Don> getAllDonAttente();
    public List<Don> getAllDonEncous();
    public List<Don> getDonByEtat(Etat etat);
    public Don getDonById(Long id);
    public Don modifierDon(Long id, Don don);
    public void annulerDon(Long id);
    public void confirmerDon(Long id);
    public void attenteDon(Long id);
    public void encoursDon(Long id);
    public void deleteDon(Long id);
 }
