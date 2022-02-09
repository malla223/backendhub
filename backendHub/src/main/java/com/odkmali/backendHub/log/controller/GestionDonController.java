package com.odkmali.backendHub.log.controller;

import com.odkmali.backendHub.log.Gestiondon;
import com.odkmali.backendHub.log.service.GestionDonServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/log")
public class GestionDonController {

    @Autowired
    GestionDonServiceImplements gestionDonServiceImplements;

    @PostMapping("/saveLog")
    @ResponseBody
    public Gestiondon saveLog(@RequestBody Gestiondon log){
        return gestionDonServiceImplements.saveLog(log);
    }

    @GetMapping("/getAllLog")
    @ResponseBody
    public List<Gestiondon> getAllLogDon(){
        return gestionDonServiceImplements.getAllLogDon();
    }

    @GetMapping("/getLogId/{id}")
    @ResponseBody
    public Gestiondon getLogById(@PathVariable("id") Long id){
        return gestionDonServiceImplements.getLogById(id);
    }

    @DeleteMapping("/deleteLog/{id}")
    public void deleteLog(@PathVariable("id") Long id){
        gestionDonServiceImplements.deleteLog(id);
    }
}
