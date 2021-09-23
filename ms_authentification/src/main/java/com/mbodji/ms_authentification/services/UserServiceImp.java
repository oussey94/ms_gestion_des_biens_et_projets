package com.mbodji.ms_authentification.services;

import com.mbodji.ms_authentification.entities.Role;
import com.mbodji.ms_authentification.entities.User;
import com.mbodji.ms_authentification.repository.RoleRepository;
import com.mbodji.ms_authentification.repository.UserRepository;
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
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user=userRepository.findByUserName(userName);
        Role role=roleRepository.findByRoleName(roleName);
        //u.getRoles().add(r);
        user.getRoles().add(role);

    }

    @Override
    public User findParUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
