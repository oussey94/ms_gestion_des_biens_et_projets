package com.mbodji.ms_gestion_des_biens_et_projets.controllers;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.BienImmobiliere;
import com.mbodji.ms_gestion_des_biens_et_projets.services.ServiceBienImmoProjet;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/biens")
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

    @GetMapping(path ="nom/{nomBien}")
    public BienImmobiliere getByNomBien(@PathVariable("nomBien") String nomBien){
        return serviceBienImmoProjet.getBienImmobiliereParNomBien(nomBien);
    }
//==================================================================================================
    @GetMapping(path = "/photoBien/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        BienImmobiliere b= serviceBienImmoProjet.getBienImmobiliereParId(id);

        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Documents/mb_memoire/bien_immo_tof/"+b.getPhotoName()));
    }

    @PostMapping(path="/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable("id") Long id) throws Exception {
        BienImmobiliere bien = serviceBienImmoProjet.getBienImmobiliereParId(id);
        bien.setPhotoName(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home")+"/Documents/mb_memoire/bien_immo_tof/"+bien.getPhotoName()), file.getBytes());

        serviceBienImmoProjet.updateBienImmo(bien);
    }

//===================================================================================================

    @PostMapping
    public BienImmobiliere addBien(@RequestBody BienImmobiliere bienImmobiliere){
        return serviceBienImmoProjet.updateBienImmo(bienImmobiliere);
    }
    @PutMapping("/{id}")
    public BienImmobiliere updateBien(@PathVariable("id") Long id, @RequestBody BienImmobiliere bienImmobiliere){
        BienImmobiliere bien = serviceBienImmoProjet.getBienImmobiliereParId(id);
        bien.setNomBien(bienImmobiliere.getNomBien());
        bien.setAvailable(bienImmobiliere.getAvailable());
        bien.setLocalisation(bienImmobiliere.getLocalisation());
        bien.setPhotoName(bienImmobiliere.getPhotoName());
        bien.setDescription(bienImmobiliere.getDescription());
        bien.setPrix(bienImmobiliere.getPrix());
        bien.setRating(bienImmobiliere.getRating());
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
