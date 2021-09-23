package com.oussey.msgestiondesutilisateurs.repository;

import com.oussey.msgestiondesutilisateurs.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
