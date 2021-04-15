package com.mbodji.ms_gestion_des_biens_et_projets.repository;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    Projet findByNomProjet(String nomProjet);
}
