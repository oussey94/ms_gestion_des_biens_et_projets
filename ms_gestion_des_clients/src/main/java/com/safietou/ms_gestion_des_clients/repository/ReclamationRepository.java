package com.safietou.ms_gestion_des_clients.repository;

import com.safietou.ms_gestion_des_clients.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
}
