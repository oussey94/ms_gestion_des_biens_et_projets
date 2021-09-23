package com.oussey.msgestiondesutilisateurs.services;

import com.oussey.msgestiondesutilisateurs.entities.Client;
import com.oussey.msgestiondesutilisateurs.entities.Proprietaire;
import com.oussey.msgestiondesutilisateurs.entities.T_role;
import com.oussey.msgestiondesutilisateurs.entities.T_user;

import java.util.List;

public interface UserService {
    T_user addNewUser(T_user tuser);
    T_role addNewRole(T_role trole);
    void addRoleToUser(String userName,String roleName);
    T_user findParUserName(String userName);
    List<T_user> listUsers();
    T_user getUserParId(Long id);
    void deleteUser(Long id);

    


}
