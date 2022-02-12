package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.model.DemandeDon;
import org.springframework.stereotype.Service;

@Service
public interface DemandeDonService {

    public DemandeDon faireDemande(DemandeDon demandeDon);
}
