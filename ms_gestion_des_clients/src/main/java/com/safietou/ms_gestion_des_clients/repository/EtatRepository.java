package com.safietou.ms_gestion_des_clients.repository;

import com.safietou.ms_gestion_des_clients.entities.Etat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatRepository extends JpaRepository<Etat, Long> {
    Etat findByNomEtat(String nomEtat);
}
