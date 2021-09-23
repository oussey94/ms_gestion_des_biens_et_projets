package com.mbodji.ms_authentification.services;

import com.mbodji.ms_authentification.entities.Role;
import com.mbodji.ms_authentification.entities.User;

import java.util.List;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    void addRoleToUser(String userName,String roleName);
    User findParUserName(String userName);
    List<User> listUsers();
}
