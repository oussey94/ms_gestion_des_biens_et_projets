package com.safietou.ms_gestion_des_clients;

import com.safietou.ms_gestion_des_clients.entities.Contrat;
import com.safietou.ms_gestion_des_clients.entities.Etat;
import com.safietou.ms_gestion_des_clients.entities.Reclamation;
import com.safietou.ms_gestion_des_clients.entities.Visite;
import com.safietou.ms_gestion_des_clients.services.ServiceGestionClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class MsGestionDesClientsApplication implements CommandLineRunner {
    private ServiceGestionClient serviceGestionClient;

    public MsGestionDesClientsApplication(ServiceGestionClient serviceGestionClient) {
        this.serviceGestionClient = serviceGestionClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(MsGestionDesClientsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        Contrat c1=serviceGestionClient.addNewContrat(new Contrat(null,1200000,120000,new Date(),6,"pour location",new ArrayList<>()));
        Contrat c2=serviceGestionClient.addNewContrat(new Contrat(null,8700000,270000,new Date(),12,"pour location",new ArrayList<>()));

        serviceGestionClient.addNewVisite(new Visite(null,new Date(),new Date(),c2));
        serviceGestionClient.addNewVisite(new Visite(null,new Date(),new Date(),c1));

        Etat e1=serviceGestionClient.addNewEtat(new Etat(null,"satisfait", new ArrayList<>()));
        Etat e2=serviceGestionClient.addNewEtat(new Etat(null,"en cours", new ArrayList<>()));

        serviceGestionClient.addNewReclamation(new Reclamation(null,"lababo en panne",e2));
        serviceGestionClient.addNewReclamation(new Reclamation(null,"l'eau ne monte pas",e1));
        */
    }
}
