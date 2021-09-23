package com.oussey.msgestiondesutilisateurs.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table
@PrimaryKeyJoinColumn

public class Client extends T_user {
    public Client() {
    }

    public Client(Long idUser, String nom, String prenom, String email, String userName, String password, double telephone1, double telephone2, String adresse, int age, String ville, Collection<T_role> troles) {
        super(idUser, nom, prenom, email, userName, password, telephone1, telephone2, adresse, age, ville, troles);
    }
}
