package com.safietou.ms_gestion_des_clients.controllers;

import com.safietou.ms_gestion_des_clients.beans.BienImmobiliereBean;
import com.safietou.ms_gestion_des_clients.beans.ClientBean;
import com.safietou.ms_gestion_des_clients.entities.Contrat;
import com.safietou.ms_gestion_des_clients.feign.BienImmobiliereRestClient;
import com.safietou.ms_gestion_des_clients.feign.ClientRestFeignClient;
import com.safietou.ms_gestion_des_clients.services.ServiceGestionClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@CrossOrigin("*")
public class ContratRestController {
    private ServiceGestionClient serviceGestionClient;
    private BienImmobiliereRestClient bienImmobiliereRestClient;
    private ClientRestFeignClient clientRestFeignClient;

    public ContratRestController(ServiceGestionClient serviceGestionClient, BienImmobiliereRestClient bienImmobiliereRestClient, ClientRestFeignClient clientRestFeignClient) {
        this.serviceGestionClient = serviceGestionClient;
        this.bienImmobiliereRestClient = bienImmobiliereRestClient;
        this.clientRestFeignClient = clientRestFeignClient;
    }
    @GetMapping
    public List<Contrat> getAllCont(){
        return serviceGestionClient.getAllContrat();
    }

    @GetMapping("/{id}")
    public Contrat getContratById(@PathVariable("id") Long id){
        Contrat contrat= serviceGestionClient.getContrat(id);
        BienImmobiliereBean bienImmobiliereBean=bienImmobiliereRestClient.getById(contrat.getBienImmobiliereID());
        ClientBean clientBean= clientRestFeignClient.getClient(contrat.getClientID());

        contrat.setBienImmobiliereBean(bienImmobiliereBean);
        contrat.setClientBean(clientBean);
        return contrat;
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
