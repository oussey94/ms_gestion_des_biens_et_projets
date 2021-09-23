package com.mbodji.ms_authentification.controllers;

import com.mbodji.ms_authentification.entities.Role;
import com.mbodji.ms_authentification.entities.User;
import com.mbodji.ms_authentification.services.UserService;
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
    public List<User> getAllUsers(){
        return userService.listUsers();
    }
    @GetMapping("/{userName}")
    public User getUserByUsername(@PathVariable("userName") String userName){
        return userService.findParUserName(userName);
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addNewUser(user);
    }
    @PostMapping("/roles")
    public Role addRole(@RequestBody Role role){
        return userService.addNewRole(role);
    }
    @PostMapping("/addRoleUser")
    public void addRoleUser(@RequestBody AddRoleUser addRoleUser){
        userService.addRoleToUser(addRoleUser.getUserName(), addRoleUser.getRoleName());

    }
@Data
    class AddRoleUser{
        private String userName;
        private String roleName;
    }
}
