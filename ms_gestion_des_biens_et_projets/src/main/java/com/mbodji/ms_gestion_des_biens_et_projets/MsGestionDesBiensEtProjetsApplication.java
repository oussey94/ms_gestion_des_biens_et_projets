package com.mbodji.ms_gestion_des_biens_et_projets;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.BienImmobiliere;
import com.mbodji.ms_gestion_des_biens_et_projets.entities.Categorie;
import com.mbodji.ms_gestion_des_biens_et_projets.entities.Projet;
import com.mbodji.ms_gestion_des_biens_et_projets.services.ServiceBienImmoProjet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class MsGestionDesBiensEtProjetsApplication implements CommandLineRunner {
    private ServiceBienImmoProjet serviceBienImmoProjet;

    public MsGestionDesBiensEtProjetsApplication(ServiceBienImmoProjet serviceBienImmoProjet) {
        this.serviceBienImmoProjet = serviceBienImmoProjet;
    }

    public static void main(String[] args) {
        SpringApplication.run(MsGestionDesBiensEtProjetsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        Categorie c1=serviceBienImmoProjet.addNewCategorie(new Categorie(null,"Immeuble",new ArrayList<>()));
        Categorie c2=serviceBienImmoProjet.addNewCategorie(new Categorie(null,"Appartement",new ArrayList<>()));
        Categorie c3=serviceBienImmoProjet.addNewCategorie(new Categorie(null,"Magasin",new ArrayList<>()));

        Projet p1=serviceBienImmoProjet.addNewProjet(new Projet(null,"futurBao","un annexes pour baobab","Somone", new ArrayList<>()));
        Projet p2=serviceBienImmoProjet.addNewProjet(new Projet(null,"MbodjiLoc","des locaux pour def-techno","Somone", new ArrayList<>()));
        Projet p3=serviceBienImmoProjet.addNewProjet(new Projet(null,"le Dioufenee","suite pour la reine","Ginaw Rail(Somone)", new ArrayList<>()));

       serviceBienImmoProjet.addNewBienImmo(new BienImmobiliere(null,"Bayee",true,"tof",12000000,"Somone",true,1200,"c'est un immeuble",c1, p1));
        serviceBienImmoProjet.addNewBienImmo(new BienImmobiliere(null,"immeuble safie",true,"tof",6000000,"Ngaparou",false,300,"c'est un immeuble",c2, p3));
        serviceBienImmoProjet.addNewBienImmo(new BienImmobiliere(null,"chez Amy",false,"tof",3000000,"Somone",true,600,"c'est un immeuble",c3, p2));
*/
    }
}
