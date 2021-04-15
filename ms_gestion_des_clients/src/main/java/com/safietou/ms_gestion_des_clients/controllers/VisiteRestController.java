package com.safietou.ms_gestion_des_clients.controllers;

import com.safietou.ms_gestion_des_clients.entities.Etat;
import com.safietou.ms_gestion_des_clients.entities.Visite;
import com.safietou.ms_gestion_des_clients.services.ServiceGestionClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visites")
@CrossOrigin("*")
public class VisiteRestController {
    private ServiceGestionClient serviceGestionClient;

    public VisiteRestController(ServiceGestionClient serviceGestionClient) {
        this.serviceGestionClient = serviceGestionClient;
    }
    @GetMapping
    public List<Visite> getAllVisite(){
        return serviceGestionClient.getAllVisite();
    }
    @GetMapping("/{id}")
    public Visite getVisite(@PathVariable("id") Long id){
        return serviceGestionClient.getVisite(id);
    }
    @PostMapping
    public Visite createVisite(@RequestBody Visite visite){
        return serviceGestionClient.addNewVisite(visite);
    }
    @PutMapping("/{id}")
    public Visite updateVisite(@PathVariable("id") Long id, @RequestBody Visite visite){
        Visite v= serviceGestionClient.getVisite(id);
        v.setDateVisite(visite.getDateVisite());
        v.setHeureVisite(visite.getHeureVisite());
        //v.setDemanderVisite(visite.getDemanderVisite());

        return serviceGestionClient.updateVisite(visite);
    }
    @DeleteMapping("/{id}")
    public void deleteVisite(@PathVariable("id") Long id){
        serviceGestionClient.deleteVisiteParId(id);
    }
}
