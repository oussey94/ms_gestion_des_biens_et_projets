package com.mbodji.ms_authentification.repository;

import com.mbodji.ms_authentification.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
