package com.odkmali.backendHub.log.service;

import com.odkmali.backendHub.log.Gestiondon;
import com.odkmali.backendHub.log.repo.GestionDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionDonServiceImplements implements GestionDonService{

    @Autowired
    GestionDonRepo gestionDonRepo;

    @Override
    public Gestiondon saveLog(Gestiondon log) {
        return gestionDonRepo.save(log);
    }

    @Override
    public List<Gestiondon> getAllLogDon() {
        return gestionDonRepo.findAll();
    }

    @Override
    public Gestiondon getLogById(Long id) {
        return gestionDonRepo.findById(id).get();
    }

    @Override
    public void deleteLog(Long id) {
        gestionDonRepo.deleteById(id);
    }
}
