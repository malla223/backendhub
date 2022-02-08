package com.odkmali.backendHub.log;


import com.odkmali.backendHub.model.Admin;
import com.odkmali.backendHub.model.Don;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gestiondon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_log;

    @OneToOne
    private Admin admin;

    @OneToOne
    private Don don;

}
