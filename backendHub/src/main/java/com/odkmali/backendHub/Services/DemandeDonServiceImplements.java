package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.DemandeDon;
import com.odkmali.backendHub.repository.DemandeDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeDonServiceImplements implements DemandeDonService{

    @Autowired
    DemandeDonRepo demandeDonRepo;

    public DemandeDon faireDemande(DemandeDon demandeDon) {
        return demandeDonRepo.save(demandeDon);
    }
}
