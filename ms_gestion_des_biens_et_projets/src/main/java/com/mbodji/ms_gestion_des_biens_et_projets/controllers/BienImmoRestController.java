package com.mbodji.ms_gestion_des_biens_et_projets.controllers;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.BienImmobiliere;
import com.mbodji.ms_gestion_des_biens_et_projets.services.ServiceBienImmoProjet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biens")
//@CrossOrigin("*")
public class BienImmoRestController {
    private ServiceBienImmoProjet serviceBienImmoProjet;

    public BienImmoRestController(ServiceBienImmoProjet serviceBienImmo) {
        this.serviceBienImmoProjet = serviceBienImmo;
    }
    @GetMapping
    public List<BienImmobiliere> getAll(){
        return serviceBienImmoProjet.getAllBienImmo();
    }

    @GetMapping("/{id}")
    public BienImmobiliere getById(@PathVariable("id") Long id){
        return serviceBienImmoProjet.getBienImmobiliereParId(id);
    }
    @PostMapping
    public BienImmobiliere updateBien(@RequestBody BienImmobiliere bienImmobiliere){
        return serviceBienImmoProjet.updateBienImmo(bienImmobiliere);
    }
    @PutMapping("/{id}")
    public BienImmobiliere addBien(@PathVariable("id") Long id, @RequestBody BienImmobiliere bienImmobiliere){
        BienImmobiliere bien = serviceBienImmoProjet.getBienImmobiliereParId(id);
        bien.setNomBien(bienImmobiliere.getNomBien());
        bien.setAvailable(bienImmobiliere.getAvailable());
        bien.setLocalisation(bienImmobiliere.getLocalisation());
        bien.setPhotoName(bienImmobiliere.getPhotoName());
        bien.setDescription(bienImmobiliere.getDescription());
        bien.setPrix(bienImmobiliere.getPrix());
        bien.setSelected(bienImmobiliere.getSelected());
        bien.setTaille(bienImmobiliere.getTaille());
        bien.setCategorie(bienImmobiliere.getCategorie());
        bien.setProjet(bienImmobiliere.getProjet());

        return serviceBienImmoProjet.addNewBienImmo(bienImmobiliere);

    }
    @DeleteMapping("/{id}")
    public void deleteBien(@PathVariable("id") Long id){
        serviceBienImmoProjet.deleteBienImmoParId(id);
    }
}
