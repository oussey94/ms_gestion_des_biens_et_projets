package com.safietou.ms_gestion_des_clients;

import com.safietou.ms_gestion_des_clients.beans.BienImmobiliereBean;
import com.safietou.ms_gestion_des_clients.beans.ClientBean;
import com.safietou.ms_gestion_des_clients.entities.Contrat;
import com.safietou.ms_gestion_des_clients.entities.Etat;
import com.safietou.ms_gestion_des_clients.entities.Reclamation;
import com.safietou.ms_gestion_des_clients.entities.Visite;
import com.safietou.ms_gestion_des_clients.feign.BienImmobiliereRestClient;
import com.safietou.ms_gestion_des_clients.feign.ClientRestFeignClient;
import com.safietou.ms_gestion_des_clients.services.ServiceGestionClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsGestionDesClientsApplication implements CommandLineRunner {
    private ServiceGestionClient serviceGestionClient;
    private BienImmobiliereRestClient bienImmobiliereRestClient;
    private ClientRestFeignClient clientRestFeignClient;

    public MsGestionDesClientsApplication(ServiceGestionClient serviceGestionClient, BienImmobiliereRestClient bienImmobiliereRestClient, ClientRestFeignClient clientRestFeignClient) {
        this.serviceGestionClient = serviceGestionClient;
        this.bienImmobiliereRestClient=bienImmobiliereRestClient;
        this.clientRestFeignClient=clientRestFeignClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(MsGestionDesClientsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BienImmobiliereBean bienImmobiliere=bienImmobiliereRestClient.getById(1L);
        ClientBean client=clientRestFeignClient.getClient(4L);
        System.out.println("==========================TEST 1 ===============");
        System.out.println(bienImmobiliere.getIdBienImmo());
        System.out.println(bienImmobiliere.getNomBien());
        System.out.println(bienImmobiliere.getTaille());
        System.out.println(bienImmobiliere.getDescription());

        System.out.println("==========================TEST 2 ===============");
        System.out.println(client.getNom());
        System.out.println(client.getPrenom());
        System.out.println(client.getAdresse());
        System.out.println(client.getVille());

        Contrat c1=serviceGestionClient.addNewContrat(new Contrat(null,1200000,120000,new Date(),6,"pour location",client.getIdUser(),new ArrayList<>(),new ArrayList<>(), null));
        Contrat c2=serviceGestionClient.addNewContrat(new Contrat(null,8700000,270000,new Date(),12,"pour location",client.getIdUser(),new ArrayList<>(),new ArrayList<>(), null));

        serviceGestionClient.addNewContrat(new Contrat(null,8700000,270000,new Date(),12,"pour location",client.getIdUser(),new ArrayList<>(),new ArrayList<>(), null));
        serviceGestionClient.addNewContrat(new Contrat(null,8700000,270000,new Date(),12,"pour location",client.getIdUser(),new ArrayList<>(),new ArrayList<>(), null));

        serviceGestionClient.addNewVisite(new Visite(null,new Date(),LocalTime.of(12,11,56),c2, bienImmobiliere.getIdBienImmo(), client.getIdUser(), null, null));
        serviceGestionClient.addNewVisite(new Visite(null,new Date(),LocalTime.of(2,2,2),c1, bienImmobiliere.getIdBienImmo(), client.getIdUser(), null, null));
        serviceGestionClient.addNewVisite(new Visite(null,new Date(),LocalTime.of(5,5,5),c2, bienImmobiliere.getIdBienImmo(), client.getIdUser(), null, null));

        Etat e1=serviceGestionClient.addNewEtat(new Etat(null,"satisfait", new ArrayList<>()));
        Etat e2=serviceGestionClient.addNewEtat(new Etat(null,"en cours", new ArrayList<>()));

        serviceGestionClient.addNewReclamation(new Reclamation(null,"lababo en panne",e2,c2));
        serviceGestionClient.addNewReclamation(new Reclamation(null,"l'eau ne monte pas",e1,c1));


    }
}
