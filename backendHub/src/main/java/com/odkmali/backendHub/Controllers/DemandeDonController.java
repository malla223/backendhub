package com.odkmali.backendHub.Controllers;

import com.odkmali.backendHub.Services.DemandeDonServiceImplements;
import com.odkmali.backendHub.model.DemandeDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/don")
public class DemandeDonController {

    @Autowired
    DemandeDonServiceImplements demandeDonServiceImplements;

    @PostMapping("/demandeDon")
    @ResponseBody
    public DemandeDon faireDemande(@RequestBody DemandeDon demandeDon) {
        return demandeDonServiceImplements.faireDemande(demandeDon);
    }
}
