package com.safietou.ms_gestion_des_clients.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safietou.ms_gestion_des_clients.beans.BienImmobiliereBean;
import com.safietou.ms_gestion_des_clients.beans.ClientBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idContrat;
    private double caution;
    private double prixEffectif;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date dateEffectif;
    private double dureeEnNbrDeMois;
    private String description;
    private Long bienImmobiliereID;
    private Long clientID;
    //@JsonIgnore
    //@OneToMany(mappedBy="contrat")
    //private Collection<Visite> visites;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="contrat")
    private Collection<Reclamation> reclamations;
    @Transient
    private BienImmobiliereBean bienImmobiliereBean;
    @Transient
    private ClientBean clientBean;
}
