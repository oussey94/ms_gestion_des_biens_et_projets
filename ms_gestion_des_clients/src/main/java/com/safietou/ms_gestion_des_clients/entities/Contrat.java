package com.safietou.ms_gestion_des_clients.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEffectif;
    private int dureeEnNbrDeMois;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy="contrat")
    private Collection<Visite> visites;
}
