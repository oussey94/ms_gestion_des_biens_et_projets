package com.safietou.ms_gestion_des_clients.beans;

import lombok.Data;

@Data
public class BienImmobiliereBean {
    private Long idBienImmo;
    private String nomBien;
    private Boolean available;
    private String photoName;
    private double prix;
    private String localisation;
    private Boolean selected;
    private double taille;
    private String description;
}
