package com.oussey.msgestiondesutilisateurs.repository;

import com.oussey.msgestiondesutilisateurs.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {
}
