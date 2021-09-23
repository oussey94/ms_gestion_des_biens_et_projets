package com.oussey.msgestiondesutilisateurs.services;

import com.oussey.msgestiondesutilisateurs.entities.Client;
import com.oussey.msgestiondesutilisateurs.entities.Proprietaire;
import com.oussey.msgestiondesutilisateurs.entities.T_role;
import com.oussey.msgestiondesutilisateurs.entities.T_user;
import com.oussey.msgestiondesutilisateurs.repository.ClientRepository;
import com.oussey.msgestiondesutilisateurs.repository.ProprietaireRepository;
import com.oussey.msgestiondesutilisateurs.repository.RoleRepository;
import com.oussey.msgestiondesutilisateurs.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public UserServiceImp(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public T_user addNewUser(T_user tuser) {
        return userRepository.save(tuser);
    }

    @Override
    public T_role addNewRole(T_role trole) {
        return roleRepository.save(trole);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        T_user tuser =userRepository.findByUserName(userName);
        T_role trole =roleRepository.findByRoleName(roleName);
        //u.getRoles().add(r);
        tuser.getTroles().add(trole);

    }

    @Override
    public T_user findParUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<T_user> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public T_user getUserParId(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
