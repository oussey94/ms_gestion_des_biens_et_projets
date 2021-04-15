package com.mbodji.ms_gestion_des_biens_et_projets.repository;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Categorie findByNomCategorie(String nomCategorie);
}
