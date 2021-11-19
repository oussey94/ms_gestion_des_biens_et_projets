package com.oussey.msgestiondesutilisateurs;

import com.oussey.msgestiondesutilisateurs.entities.Client;
import com.oussey.msgestiondesutilisateurs.entities.Proprietaire;
import com.oussey.msgestiondesutilisateurs.entities.T_role;
import com.oussey.msgestiondesutilisateurs.entities.T_user;
import com.oussey.msgestiondesutilisateurs.entities.*;
import com.oussey.msgestiondesutilisateurs.services.ClientService;
import com.oussey.msgestiondesutilisateurs.services.ProprietaireService;
import com.oussey.msgestiondesutilisateurs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;

@SpringBootApplication
@EnableDiscoveryClient
public class MsGestionDesUtilisateursApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProprietaireService proprietaireService;

    public static void main(String[] args) {
        SpringApplication.run(MsGestionDesUtilisateursApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        userService.addNewRole(new T_role(null,"ADMIN"));
        userService.addNewRole(new T_role(null,"USER"));

        userService.addNewUser(new T_user(null,"mbodji","oussey","mbo@gmail.com","ouss94","pwd",778291145,760724384,"Somone",26,"Somone ville", new ArrayList<>()));
        userService.addNewUser(new T_user(null,"mbodji","mame","mbo@gmail.com","ouss945","pwd",778291145,760724384,"Somone",26,"Somone ville", new ArrayList<>()));
        userService.addNewUser(new T_user(null,"mbodji","fatou","mbo@gmail.com","ouss946","pwd",778291145,760724384,"Somone",26,"Somone ville", new ArrayList<>()));

        userService.addNewUser(new Client(null,"Diouf","safietou","saf@gmail.com","saf94","pwdsss",778291145,760724384,"Somone Kanda",26,"Somone", new ArrayList<>()));
        userService.addNewUser(new Client(null,"Diouf","ada","saf@gmail.com","saf945","pwdsss",778291145,760724384,"Somone Kanda",26,"Somone", new ArrayList<>()));
        userService.addNewUser(new Client(null,"Diouf","ouz","saf@gmail.com","saf946","pwdsss",778291145,760724384,"Somone Kanda",26,"Somone", new ArrayList<>()));

        userService.addNewUser(new Proprietaire(null,"dieye","amy","amy@gmail.com","amy96","pwdaaa",778291145,760724384,"St louis",26,"St louis", new ArrayList<>()));
        userService.addNewUser(new Proprietaire(null,"dieye","awa","amy@gmail.com","amy965","pwdaaa",778291145,760724384,"St louis",26,"St louis", new ArrayList<>()));
        userService.addNewUser(new Proprietaire(null,"dieye","amy","amy@gmail.com","amy964","pwdaaa",778291145,760724384,"St louis",26,"St louis", new ArrayList<>()));

        userService.addRoleToUser("ouss94","ADMIN");

        userService.addRoleToUser("ouss94","USER");
        userService.addRoleToUser("amy96","USER");
        userService.addRoleToUser("saf94","ADMIN");


    }
}
