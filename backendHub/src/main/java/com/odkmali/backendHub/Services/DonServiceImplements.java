package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.Don;
import com.odkmali.backendHub.repository.DonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DonServiceImplements implements DonService{

    @Autowired
    DonRepo donRepo;

    public Don saveDon(Don don) {
        return null;
    }


    public List<Don> getAllDon() {
        return null;
    }


    public List<Don> getAllDonConfirmer() {
        return null;
    }


    public List<Don> getAllDonInactif() {
        return null;
    }


    public List<Don> getAllDonAttente() {
        return null;
    }


    public List<Don> getAllDonEncous() {
        return null;
    }


    public List<Don> getDonByEtat(String etat) {
        return null;
    }


    public Don getDonById(Long id) {
        return null;
    }


    public Don modifierDon(Long id, Don don) {
        return null;
    }


    public void deleteDon(Long id) {

    }


    public Don restaurerDon(Long id) {
        return null;
    }
}
