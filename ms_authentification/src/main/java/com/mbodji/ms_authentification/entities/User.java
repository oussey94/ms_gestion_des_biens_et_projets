package com.mbodji.ms_authentification.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity(name="utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor

@ToString
@Inheritance(strategy= InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

}
