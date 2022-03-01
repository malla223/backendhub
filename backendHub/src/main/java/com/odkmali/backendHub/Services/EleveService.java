package com.odkmali.backendHub.Services;

import com.odkmali.backendHub.enumeration.Etat;
import com.odkmali.backendHub.model.Eleve;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EleveService {

    public List<Eleve> getEleveByEtat(Etat etat);
    public Eleve getEleveById(Long id);
    public List<Eleve> getAllEleve();
    void deleteEleve(Long id);
    void restaurerEleve(Long id);
    public Eleve saveEleve(Eleve eleve);
    public Eleve modifierEleve(Long id, Eleve eleve);
}
