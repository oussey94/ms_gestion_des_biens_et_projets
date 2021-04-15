package com.mbodji.ms_gestion_des_biens_et_projets.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjet;
    private String nomProjet;
    private String description;
    private String localisation;
    @JsonIgnore
    @OneToMany(mappedBy= "projet")
    private Collection<BienImmobiliere> bienImmobilieres;
}
