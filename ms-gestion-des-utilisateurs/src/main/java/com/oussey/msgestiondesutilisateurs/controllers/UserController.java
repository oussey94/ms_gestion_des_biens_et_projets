package com.oussey.msgestiondesutilisateurs.controllers;

import com.oussey.msgestiondesutilisateurs.entities.Client;
import com.oussey.msgestiondesutilisateurs.entities.T_role;
import com.oussey.msgestiondesutilisateurs.entities.T_user;
import com.oussey.msgestiondesutilisateurs.services.UserService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<T_user> getAllUsers(){
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public T_user getUser(@PathVariable("id") Long id){
        return userService.getUserParId(id);
    }
    
    @PutMapping("/{id}")
    public T_user updateUser(@PathVariable("id") Long id, @RequestBody T_user t_user){
        T_user u = userService.getUserParId(id);

        u.setPrenom(t_user.getPrenom());
        u.setNom(t_user.getNom());
        u.setAge(t_user.getAge());
        u.setEmail(t_user.getEmail());
        u.setPassword(t_user.getPassword());
        u.setTelephone1(t_user.getTelephone1());
        u.setTelephone2(t_user.getTelephone2());
        u.setAdresse(t_user.getAdresse());
        u.setVille(t_user.getVille());
        u.setUserName(t_user.getUserName());

        return userService.addNewUser(t_user);
    }

    @GetMapping(path ="/login/{userName}")
    public T_user getUserByUsername(@PathVariable("userName") String userName){
        return userService.findParUserName(userName);
    }

    @PostMapping
    public T_user addUser(@RequestBody T_user tuser){
        return userService.addNewUser(tuser);
    }

    @PostMapping("/roles")
    public T_role addRole(@RequestBody T_role trole){
        return userService.addNewRole(trole);
    }

    @PostMapping("/addRoleUser")
    public void addRoleUser(@RequestBody AddRoleUser addRoleUser){
        userService.addRoleToUser(addRoleUser.getUserName(), addRoleUser.getRoleName());

    }
}

@Data
class AddRoleUser{
    private String userName;
    private String roleName;
}
