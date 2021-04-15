package com.mbodji.ms_gestion_des_biens_et_projets.controllers;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.Projet;
import com.mbodji.ms_gestion_des_biens_et_projets.services.ServiceBienImmoProjet;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/projets")
@CrossOrigin("*")
public class ProjetRestController {
    private ServiceBienImmoProjet serviceBienImmoProjet;

    public ProjetRestController(ServiceBienImmoProjet serviceBienImmo) {
        this.serviceBienImmoProjet = serviceBienImmo;
    }
    @GetMapping
    public List<Projet> getAll(){

        return serviceBienImmoProjet.getAllProjet();
    }

    @GetMapping("/{id}")
    public Projet getById(@PathVariable("id") Long id){
        return serviceBienImmoProjet.getProjetParId(id);
    }
    @PostMapping
    public Projet updateProj(@RequestBody Projet projet){
        return serviceBienImmoProjet.updateProjet(projet);
    }
    @PutMapping("/{id}")
    public Projet addProj(@PathVariable("id") Long id, @RequestBody Projet projet){
        Projet proj = serviceBienImmoProjet.getProjetParId(id);
        proj.setNomProjet(projet.getNomProjet());
        proj.setDescription(projet.getDescription());
        proj.setLocalisation(projet.getLocalisation());

        return serviceBienImmoProjet.addNewProjet(projet);

    }
    @DeleteMapping("/{id}")
    public void deleteProj(@PathVariable("id") Long id){
        serviceBienImmoProjet.deleteProjetParId(id);
    }
}
