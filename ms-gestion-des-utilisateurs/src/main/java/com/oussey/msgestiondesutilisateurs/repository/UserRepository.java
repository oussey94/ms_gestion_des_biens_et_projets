package com.oussey.msgestiondesutilisateurs.repository;

import com.oussey.msgestiondesutilisateurs.entities.T_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<T_user, Long> {
    T_user findByUserName(String userName);
}
