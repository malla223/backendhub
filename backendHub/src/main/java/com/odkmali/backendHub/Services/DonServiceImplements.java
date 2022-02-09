package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Don;
import com.odkmali.backendHub.repository.DonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DonServiceImplements implements DonService{

    @Autowired
    DonRepo donRepo;

    @Override
    public Don saveDon(Don don) {
        return donRepo.save(don);
    }

    @Override
    public List<Don> getAllDonConfirmer() {
        return donRepo.getAllDonConfirmer();
    }

    @Override
    public List<Don> getAllDonAttente() {
        return donRepo.getAllDonAttente();
    }

    @Override
    public List<Don> getAllDonEncous() {
        return donRepo.getAllDonEncours();
    }

    @Override
    public List<Don> getDonByEtat(Etat etat) {
        return donRepo.getAllDonByEtat(etat);
    }

    @Override
    public Don getDonById(Long id) {
        return donRepo.findById(id).get();
    }

    @Override
    public Don modifierDon(Long id, Don don) {
        Don d = donRepo.findById(id).get();
        d.setCategorie(don.getCategorie());
        d.setNiveau(don.getNiveau());
        d.setLibelle_don(don.getLibelle_don());
        d.setEcole(don.getEcole());
        d.setEcole(don.getEcole());
        d.setPhoto_don(don.getPhoto_don());
        return donRepo.save(don);
    }

    @Override
    public void annulerDon(Long id) {
        donRepo.annulerDon(id);
    }

    @Override
    public void confirmerDon(Long id) {
        donRepo.confirmerDon(id);
    }

    @Override
    public void attenteDon(Long id) {
        donRepo.attenteDon(id);
    }

    @Override
    public void encoursDon(Long id) {
        donRepo.encoursDon(id);
    }

    @Override
    public void deleteDon(Long id) {
        donRepo.deleteDon(id);
    }
}
