package com.safietou.ms_gestion_des_clients.controllers;

import com.safietou.ms_gestion_des_clients.entities.Contrat;
import com.safietou.ms_gestion_des_clients.services.ServiceGestionClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@CrossOrigin("*")
public class ContratRestController {
    private ServiceGestionClient serviceGestionClient;

    public ContratRestController(ServiceGestionClient serviceGestionClient) {
        this.serviceGestionClient = serviceGestionClient;
    }
    @GetMapping
    public List<Contrat> getAllCont(){
        return serviceGestionClient.getAllContrat();
    }

    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable("id") Long id){
        return serviceGestionClient.getContrat(id);
    }
    @PostMapping
    public Contrat createContrat(@RequestBody Contrat contrat){
        return serviceGestionClient.addNewContrat(contrat);
    }
    @PutMapping("/{id}")
    public Contrat updateCont(@PathVariable("id") Long id, @RequestBody Contrat contrat){
        Contrat c=serviceGestionClient.getContrat(id);
        c.setCaution(contrat.getCaution());
        c.setPrixEffectif(contrat.getPrixEffectif());
        c.setDateEffectif(contrat.getDateEffectif());
        c.setDureeEnNbrDeMois(contrat.getDureeEnNbrDeMois());
        c.setDescription(contrat.getDescription());

        return serviceGestionClient.updateContrat(contrat);
    }
    @DeleteMapping("/{id}")
    public void deleteCont(@PathVariable("id") Long id){
        serviceGestionClient.deleteContratParId(id);
    }
}
