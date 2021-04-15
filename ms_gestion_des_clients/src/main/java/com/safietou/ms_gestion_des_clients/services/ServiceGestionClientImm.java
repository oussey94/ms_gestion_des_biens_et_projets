package com.safietou.ms_gestion_des_clients.services;

import com.safietou.ms_gestion_des_clients.entities.Contrat;
import com.safietou.ms_gestion_des_clients.entities.Etat;
import com.safietou.ms_gestion_des_clients.entities.Reclamation;
import com.safietou.ms_gestion_des_clients.entities.Visite;
import com.safietou.ms_gestion_des_clients.repository.ContratRepository;
import com.safietou.ms_gestion_des_clients.repository.EtatRepository;
import com.safietou.ms_gestion_des_clients.repository.ReclamationRepository;
import com.safietou.ms_gestion_des_clients.repository.VisiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceGestionClientImm implements ServiceGestionClient{
    private ContratRepository contratRepository;
    private EtatRepository etatRepository;
    private ReclamationRepository reclamationRepository;
    private VisiteRepository visiteRepository;

    public ServiceGestionClientImm(ContratRepository contratRepository, EtatRepository etatRepository,
                                   ReclamationRepository reclamationRepository, VisiteRepository visiteRepository) {
        this.contratRepository = contratRepository;
        this.etatRepository = etatRepository;
        this.reclamationRepository = reclamationRepository;
        this.visiteRepository = visiteRepository;
    }

    @Override
    public Contrat addNewContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContratParId(Long id) {
        contratRepository.deleteById(id);

    }

    @Override
    public void deleteContrat(Contrat contrat) {
        contratRepository.delete(contrat);

    }

    @Override
    public Contrat getContrat(Long id) {
        return contratRepository.findById(id).get();
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Etat addNewEtat(Etat etat) {
        return etatRepository.save(etat);
    }

    @Override
    public Etat updateEtat(Etat etat) {
        return etatRepository.save(etat);
    }

    @Override
    public void deleteEtatParId(Long id) {
        etatRepository.deleteById(id);

    }

    @Override
    public void deleteEtat(Etat etat) {
        etatRepository.delete(etat);

    }

    @Override
    public Etat getEtat(Long id) {
        return etatRepository.findById(id).get();
    }

    @Override
    public List<Etat> getAllEtat() {
        return etatRepository.findAll();
    }

    @Override
    public Reclamation addNewReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public void deleteReclamationParId(Long id) {
        reclamationRepository.deleteById(id);

    }

    @Override
    public void deleteReclamation(Reclamation reclamation) {
        reclamationRepository.delete(reclamation);

    }

    @Override
    public Reclamation getReclamation(Long id) {
        return reclamationRepository.findById(id).get();
    }

    @Override
    public List<Reclamation> getAllReclamation() {
        return reclamationRepository.findAll();
    }

    @Override
    public Visite addNewVisite(Visite visite) {
        return visiteRepository.save(visite);
    }

    @Override
    public Visite updateVisite(Visite visite) {
        return visiteRepository.save(visite);
    }

    @Override
    public void deleteVisiteParId(Long id) {
        visiteRepository.deleteById(id);

    }

    @Override
    public void deleteVisite(Visite visite) {
        visiteRepository.delete(visite);

    }

    @Override
    public Visite getVisite(Long id) {
        return visiteRepository.findById(id).get();
    }

    @Override
    public List<Visite> getAllVisite() {
        return visiteRepository.findAll();
    }
}
