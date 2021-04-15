package com.mbodji.ms_gestion_des_biens_et_projets.services;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.BienImmobiliere;
import com.mbodji.ms_gestion_des_biens_et_projets.entities.Categorie;
import com.mbodji.ms_gestion_des_biens_et_projets.entities.Projet;

import java.util.List;

public interface ServiceBienImmoProjet {

    BienImmobiliere addNewBienImmo(BienImmobiliere bienImmobiliere);
    BienImmobiliere updateBienImmo(BienImmobiliere bienImmobiliere);
    void deleteBienImmo(BienImmobiliere bienImmobiliere);
    void deleteBienImmoParId(Long id);
    BienImmobiliere getBienImmobiliereParId(Long id);
    List<BienImmobiliere> getAllBienImmo();


    Projet addNewProjet(Projet projet);
    Projet updateProjet(Projet projet);
    void deleteProjet(Projet projet);
    void deleteProjetParId(Long id);
    Projet getProjetParId(Long id);
    List<Projet> getAllProjet();


    Categorie addNewCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie);
    void deleteCategorieParId(Long id);
    void deleteCategorie(Categorie categorie);
    Categorie getCategorieParId(Long id);
    List<Categorie> getAllCategorie();

}
