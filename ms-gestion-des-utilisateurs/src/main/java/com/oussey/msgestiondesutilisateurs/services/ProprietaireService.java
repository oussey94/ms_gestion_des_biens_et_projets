package com.oussey.msgestiondesutilisateurs.services;

import com.oussey.msgestiondesutilisateurs.entities.Client;
import com.oussey.msgestiondesutilisateurs.entities.Proprietaire;

import java.util.List;

public interface ProprietaireService {

    Proprietaire addNewProprietaire(Proprietaire proprietaire);
    Proprietaire updateProprietaire(Proprietaire proprietaire);
    void deleteProprietaire(Long id);
    List<Proprietaire> getAllPropritaire();
    Proprietaire getPropritaireParId(Long id);

}
