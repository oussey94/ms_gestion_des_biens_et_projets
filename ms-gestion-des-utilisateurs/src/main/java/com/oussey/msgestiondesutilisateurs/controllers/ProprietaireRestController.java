package com.oussey.msgestiondesutilisateurs.controllers;

import com.oussey.msgestiondesutilisateurs.entities.Proprietaire;
import com.oussey.msgestiondesutilisateurs.services.ProprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprietaires")
@CrossOrigin("*")
public class ProprietaireRestController {
    @Autowired
    private ProprietaireService propritaireService;

    @GetMapping
    public List<Proprietaire> getAllProp() {
        return propritaireService.getAllPropritaire();
    }

    @GetMapping("/{id}")
    public Proprietaire getProp(@PathVariable("id") Long id) {
        return propritaireService.getPropritaireParId(id);
    }

    @PostMapping
    public Proprietaire addProp(@RequestBody Proprietaire proprietaire) {
        return propritaireService.addNewProprietaire(proprietaire);
    }
    @DeleteMapping("/{id}")
    public void deleteProp(@PathVariable("id") Long id) {
        propritaireService.deleteProprietaire(id);
    }

    @PutMapping("/{id}")
    public Proprietaire updateProp(@PathVariable("id") Long id, @RequestBody Proprietaire proprietaire) {
        Proprietaire c=propritaireService.getPropritaireParId(id);
        c.setPrenom(proprietaire.getPrenom());
        c.setNom(proprietaire.getNom());
        c.setAge(proprietaire.getAge());
        c.setEmail(proprietaire.getEmail());
        c.setPassword(proprietaire.getPassword());
        c.setTelephone1(proprietaire.getTelephone1());
        c.setTelephone2(proprietaire.getTelephone2());
        c.setAdresse(proprietaire.getAdresse());
        c.setVille(proprietaire.getVille());
        c.setUserName(proprietaire.getUserName());

        return propritaireService.updateProprietaire(proprietaire);
    }

}
