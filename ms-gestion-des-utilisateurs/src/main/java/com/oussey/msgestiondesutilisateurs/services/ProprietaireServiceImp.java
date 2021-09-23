package com.oussey.msgestiondesutilisateurs.services;

import com.oussey.msgestiondesutilisateurs.entities.Proprietaire;
import com.oussey.msgestiondesutilisateurs.repository.ProprietaireRepository;
import com.oussey.msgestiondesutilisateurs.repository.RoleRepository;
import com.oussey.msgestiondesutilisateurs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProprietaireServiceImp implements ProprietaireService{
    @Autowired
    private ProprietaireRepository propritaireRepository;

    @Override
    public Proprietaire addNewProprietaire(Proprietaire proprietaire) {
        return propritaireRepository.save(proprietaire);
    }

    @Override
    public Proprietaire updateProprietaire(Proprietaire proprietaire) {
        return propritaireRepository.save(proprietaire);
    }

    @Override
    public void deleteProprietaire(Long id) {
        propritaireRepository.deleteById(id);

    }

    @Override
    public List<Proprietaire> getAllPropritaire() {
        return propritaireRepository.findAll();
    }

    @Override
    public Proprietaire getPropritaireParId(Long id) {
        return propritaireRepository.findById(id).get();
    }
}
