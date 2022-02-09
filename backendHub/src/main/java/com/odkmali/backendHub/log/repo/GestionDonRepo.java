package com.odkmali.backendHub.log.repo;

import com.odkmali.backendHub.log.Gestiondon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GestionDonRepo extends JpaRepository<Gestiondon, Long> {

}
