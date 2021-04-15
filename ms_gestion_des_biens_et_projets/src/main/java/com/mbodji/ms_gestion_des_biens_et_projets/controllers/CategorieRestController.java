package com.mbodji.ms_gestion_des_biens_et_projets.controllers;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.BienImmobiliere;
import com.mbodji.ms_gestion_des_biens_et_projets.entities.Categorie;
import com.mbodji.ms_gestion_des_biens_et_projets.services.ServiceBienImmoProjet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategorieRestController {
    private ServiceBienImmoProjet serviceBienImmoProjet;

    public CategorieRestController(ServiceBienImmoProjet serviceBienImmo) {
        this.serviceBienImmoProjet = serviceBienImmo;
    }
    @GetMapping
    public List<Categorie> getAll(){

        return serviceBienImmoProjet.getAllCategorie();
    }

    @GetMapping("/{id}")
    public Categorie getById(@PathVariable("id") Long id){
        return serviceBienImmoProjet.getCategorieParId(id);
    }
    @PostMapping
    public Categorie updateCat(@RequestBody Categorie categorie){
        return serviceBienImmoProjet.updateCategorie(categorie);
    }
    @PutMapping("/{id}")
    public Categorie addCat(@PathVariable("id") Long id, @RequestBody Categorie categorie){
        Categorie cat = serviceBienImmoProjet.getCategorieParId(id);
        cat.setNomCategorie(categorie.getNomCategorie());
        cat.setBienImmobilieres(categorie.getBienImmobilieres());

        return serviceBienImmoProjet.addNewCategorie(categorie);

    }
    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable("id") Long id){
        serviceBienImmoProjet.deleteCategorieParId(id);
    }
}
