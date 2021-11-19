package com.safietou.ms_gestion_des_clients.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safietou.ms_gestion_des_clients.beans.BienImmobiliereBean;
import com.safietou.ms_gestion_des_clients.beans.BienImmobiliereBean;
import com.safietou.ms_gestion_des_clients.beans.ClientBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateVisite;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime heureVisite;
    //private String demanderVisite;
    //@JsonIgnore
    //@ManyToOne
    //private Contrat contrat;
    private Long bienImmobiliereID;
    private Long clientID;
    @Transient
    private BienImmobiliereBean bienImmobiliereBean;
    @Transient
    private ClientBean clientBean;

}
