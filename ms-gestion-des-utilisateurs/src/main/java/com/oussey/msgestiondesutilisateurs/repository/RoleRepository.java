package com.oussey.msgestiondesutilisateurs.repository;

import com.oussey.msgestiondesutilisateurs.entities.T_role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<T_role, Long> {
    T_role findByRoleName(String roleName);
}
