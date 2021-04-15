package com.mbodji.ms_gestion_des_biens_et_projets.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BienImmobiliere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBienImmo;
    private String nomBien;
    private Boolean available;
    private String photoName;
    private double prix;
    private String localisation;
    private Boolean selected;
    private double taille;
    private String description;
    @JsonIgnore
    @ManyToOne
    private Categorie categorie;
    @JsonIgnore
    @ManyToOne
    private Projet projet;
}
