package com.safietou.ms_gestion_des_clients.controllers;

import com.safietou.ms_gestion_des_clients.beans.BienImmobiliereBean;
import com.safietou.ms_gestion_des_clients.beans.ClientBean;
import com.safietou.ms_gestion_des_clients.entities.Etat;
import com.safietou.ms_gestion_des_clients.entities.Visite;
import com.safietou.ms_gestion_des_clients.feign.BienImmobiliereRestClient;
import com.safietou.ms_gestion_des_clients.feign.ClientRestFeignClient;
import com.safietou.ms_gestion_des_clients.services.ServiceGestionClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visites")
@CrossOrigin("*")
public class VisiteRestController {
    private ServiceGestionClient serviceGestionClient;
    private BienImmobiliereRestClient bienImmobiliereRestClient;
    private ClientRestFeignClient clientRestFeignClient;

    public VisiteRestController(ServiceGestionClient serviceGestionClient, BienImmobiliereRestClient bienImmobiliereRestClient, ClientRestFeignClient clientRestFeignClient) {
        this.serviceGestionClient = serviceGestionClient;
        this.bienImmobiliereRestClient=bienImmobiliereRestClient;
        this.clientRestFeignClient=clientRestFeignClient;
    }

    @GetMapping
    public List<Visite> getAllVisite(){
        return serviceGestionClient.getAllVisite();
    }

    @GetMapping("/{id}")
    public Visite getVisite(@PathVariable("id") Long id){
        Visite visite=serviceGestionClient.getVisite(id);
        BienImmobiliereBean bienImmobiliereBean=bienImmobiliereRestClient.getById(visite.getBienImmobiliereID());
        ClientBean clientBean = clientRestFeignClient.getClient(visite.getClientID());

        visite.setBienImmobiliereBean(bienImmobiliereBean);
        visite.setClientBean(clientBean);
        return visite;
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
