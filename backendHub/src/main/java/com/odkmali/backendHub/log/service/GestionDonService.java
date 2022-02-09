package com.odkmali.backendHub.log.service;

import com.odkmali.backendHub.log.Gestiondon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GestionDonService {

    public Gestiondon saveLog(Gestiondon log);
    public List<Gestiondon> getAllLogDon();
    public Gestiondon getLogById(Long id);
    public void deleteLog(Long id);

}
