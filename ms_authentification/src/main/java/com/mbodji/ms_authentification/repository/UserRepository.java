package com.mbodji.ms_authentification.repository;

import com.mbodji.ms_authentification.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    User findByUserName(String userName);
}
