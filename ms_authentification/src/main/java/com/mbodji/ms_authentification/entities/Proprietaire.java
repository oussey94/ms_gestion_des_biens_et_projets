package com.mbodji.ms_authentification.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table
@PrimaryKeyJoinColumn

public class Proprietaire extends User{
    public Proprietaire() {
    }

    public Proprietaire(Long idUser, String nom, String prenom, String email, String userName, String password, double telephone1, double telephone2, String adresse, int age, String ville, Collection<Role> roles) {
        super(idUser, nom, prenom, email, userName, password, telephone1, telephone2, adresse, age, ville, roles);
    }
}

