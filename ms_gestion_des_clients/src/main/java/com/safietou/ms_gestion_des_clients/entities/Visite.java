package com.safietou.ms_gestion_des_clients.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVisite;
    @Temporal(TemporalType.DATE)
    private Date dateVisite;
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureVisite;
    //private String demanderVisite;
    @JsonIgnore
    @ManyToOne
    private Contrat contrat;

}
