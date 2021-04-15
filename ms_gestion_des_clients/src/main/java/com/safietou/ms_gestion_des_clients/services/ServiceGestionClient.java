package com.safietou.ms_gestion_des_clients.services;

import com.safietou.ms_gestion_des_clients.entities.Contrat;
import com.safietou.ms_gestion_des_clients.entities.Etat;
import com.safietou.ms_gestion_des_clients.entities.Reclamation;
import com.safietou.ms_gestion_des_clients.entities.Visite;

import java.util.List;

public interface ServiceGestionClient {
    Contrat addNewContrat(Contrat contrat);
    Contrat updateContrat(Contrat contrat);
    void deleteContratParId(Long id);
    void deleteContrat(Contrat contrat);
    Contrat getContrat(Long id);
    List<Contrat> getAllContrat();

    Etat addNewEtat(Etat etat);
    Etat updateEtat(Etat etat);
    void deleteEtatParId(Long id);
    void deleteEtat(Etat etat);
    Etat getEtat(Long id);
    List<Etat> getAllEtat();

    Reclamation addNewReclamation(Reclamation reclamation);
    Reclamation updateReclamation(Reclamation reclamation);
    void deleteReclamationParId(Long id);
    void deleteReclamation(Reclamation reclamation);
    Reclamation getReclamation(Long id);
    List<Reclamation> getAllReclamation();

    Visite addNewVisite(Visite visite);
    Visite updateVisite(Visite visite);
    void deleteVisiteParId(Long id);
    void deleteVisite(Visite visite);
    Visite getVisite(Long id);
    List<Visite> getAllVisite();
}
