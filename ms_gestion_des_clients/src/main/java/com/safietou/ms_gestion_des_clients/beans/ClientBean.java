package com.safietou.ms_gestion_des_clients.beans;

import lombok.Data;

@Data
public class ClientBean {
    private Long idUser;
    private String nom;
    private String prenom;
    private String email;
    private String userName;
    private String password;
    private double telephone1;
    private double telephone2;
    private String adresse;
    private int age;
    private String ville;
}
