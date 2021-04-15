package com.safietou.ms_gestion_des_clients.controllers;

import com.safietou.ms_gestion_des_clients.entities.Etat;
import com.safietou.ms_gestion_des_clients.services.ServiceGestionClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etats")
@CrossOrigin("*")
public class EtatRestController {
    private ServiceGestionClient serviceGestionClient;

    public EtatRestController(ServiceGestionClient serviceGestionClient) {
        this.serviceGestionClient = serviceGestionClient;
    }
    @GetMapping
    public List<Etat> getAllEtat(){
        return serviceGestionClient.getAllEtat();
    }
    @GetMapping("/{id}")
    public Etat getEtat(@PathVariable("id") Long id){
        return serviceGestionClient.getEtat(id);
    }
    @PostMapping
    public Etat createEtat(@RequestBody Etat etat){
        return serviceGestionClient.addNewEtat(etat);
    }
    @PutMapping("/{id}")
    public Etat updateEtat(@PathVariable("id") Long id, @RequestBody Etat etat){
        Etat e= serviceGestionClient.getEtat(id);
        e.setNomEtat(etat.getNomEtat());

        return serviceGestionClient.updateEtat(etat);
    }
    @DeleteMapping("/{id}")
    public void deleteEt(@PathVariable("id") Long id){
        serviceGestionClient.deleteEtatParId(id);
    }
}
