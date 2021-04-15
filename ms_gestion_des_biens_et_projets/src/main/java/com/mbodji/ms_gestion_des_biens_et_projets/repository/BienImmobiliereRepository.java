package com.mbodji.ms_gestion_des_biens_et_projets.repository;

import com.mbodji.ms_gestion_des_biens_et_projets.entities.BienImmobiliere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BienImmobiliereRepository extends JpaRepository<BienImmobiliere, Long> {
    BienImmobiliere findByNomBien(String nomBien);
}
