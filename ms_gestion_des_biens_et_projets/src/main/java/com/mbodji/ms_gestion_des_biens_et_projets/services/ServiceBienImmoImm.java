package com.mbodji.ms_gestion_des_biens_et_projets.services;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.BienImmobiliere;
import com.mbodji.ms_gestion_des_biens_et_projets.entities.Categorie;
import com.mbodji.ms_gestion_des_biens_et_projets.entities.Projet;
import com.mbodji.ms_gestion_des_biens_et_projets.repository.BienImmobiliereRepository;
import com.mbodji.ms_gestion_des_biens_et_projets.repository.CategorieRepository;
import com.mbodji.ms_gestion_des_biens_et_projets.repository.ProjetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceBienImmoImm implements ServiceBienImmoProjet {
    private BienImmobiliereRepository bienImmobiliereRepository;
    private ProjetRepository projetRepository;
    private CategorieRepository categorieRepository;

    public ServiceBienImmoImm(BienImmobiliereRepository bienImmobiliereRepository, ProjetRepository projetRepository, CategorieRepository categorieRepository) {
        this.bienImmobiliereRepository = bienImmobiliereRepository;
        this.projetRepository = projetRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public BienImmobiliere addNewBienImmo(BienImmobiliere bienImmobiliere) {
        return bienImmobiliereRepository.save(bienImmobiliere);
    }

    @Override
    public BienImmobiliere updateBienImmo(BienImmobiliere bienImmobiliere) {
        return bienImmobiliereRepository.save(bienImmobiliere);
    }

    @Override
    public void deleteBienImmo(BienImmobiliere bienImmobiliere) {
        bienImmobiliereRepository.delete(bienImmobiliere);

    }

    @Override
    public void deleteBienImmoParId(Long id) {
        bienImmobiliereRepository.deleteById(id);

    }

    @Override
    public BienImmobiliere getBienImmobiliereParId(Long id) {
        return bienImmobiliereRepository.findById(id).get();
    }

    @Override
    public List<BienImmobiliere> getAllBienImmo() {
        return bienImmobiliereRepository.findAll();
    }

    @Override
    public Projet addNewProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public Projet updateProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void deleteProjet(Projet projet) {
        projetRepository.delete(projet);

    }

    @Override
    public void deleteProjetParId(Long id) {
        projetRepository.deleteById(id);

    }

    @Override
    public Projet getProjetParId(Long id) {
        return projetRepository.findById(id).get();
    }

    @Override
    public List<Projet> getAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Categorie addNewCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorieParId(Long id) {
        categorieRepository.deleteById(id);

    }

    @Override
    public void deleteCategorie(Categorie categorie) {
        categorieRepository.delete(categorie);

    }

    @Override
    public Categorie getCategorieParId(Long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }
}
