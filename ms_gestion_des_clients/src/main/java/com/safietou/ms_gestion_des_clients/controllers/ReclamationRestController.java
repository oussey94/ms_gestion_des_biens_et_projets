package com.safietou.ms_gestion_des_clients.controllers;

import com.safietou.ms_gestion_des_clients.entities.Etat;
import com.safietou.ms_gestion_des_clients.entities.Reclamation;
import com.safietou.ms_gestion_des_clients.services.ServiceGestionClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamations")
@CrossOrigin("*")
public class ReclamationRestController {
    private ServiceGestionClient serviceGestionClient;

    public ReclamationRestController(ServiceGestionClient serviceGestionClient) {
        this.serviceGestionClient = serviceGestionClient;
    }
    @GetMapping
    public List<Reclamation> getAllRec(){
        return serviceGestionClient.getAllReclamation();
    }
    @GetMapping("/{id}")
    public Reclamation getRec(@PathVariable("id") Long id){
        return serviceGestionClient.getReclamation(id);
    }
    @PostMapping
    public Reclamation createRec(@RequestBody Reclamation reclamation){
        return serviceGestionClient.addNewReclamation(reclamation);
    }
    @PutMapping("/{id}")
    public Reclamation updateRec(@PathVariable("id") Long id, @RequestBody Reclamation reclamation){
        Reclamation r= serviceGestionClient.getReclamation(id);
        r.setCommentaire(reclamation.getCommentaire());

        return serviceGestionClient.updateReclamation(reclamation);
    }
    @DeleteMapping("/{id}")
    public void deleteRec(@PathVariable("id") Long id){
        serviceGestionClient.deleteReclamationParId(id);
    }
}
