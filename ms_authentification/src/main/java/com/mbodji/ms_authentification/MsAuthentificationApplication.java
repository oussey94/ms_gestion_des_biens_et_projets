package com.mbodji.ms_authentification;

import com.mbodji.ms_authentification.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsAuthentificationApplication implements CommandLineRunner {
   private UserService userService;

    public MsAuthentificationApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MsAuthentificationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // userService.addNewRole(new Role(null,"ADMIN"));
       // userService.addNewRole(new Role(null,"USER"));

        //userService.addNewUser(new User(null,"mbodji","oussey","mbo@gmail.com","ouss94","pwd",778291145,760724384,"Somone",26,"Somone ville", new ArrayList<>()));
       // userService.addNewUser(new Client(null,"Diouf","safietou","saf@gmail.com","saf94","pwdsss",778291145,760724384,"Somone Kanda",26,"Somone", new ArrayList<>()));
        //userService.addNewUser(new Proprietaire(null,"dieye","amy","amy@gmail.com","amy96","pwdaaa",778291145,760724384,"St louis",26,"St louis", new ArrayList<>()));

        userService.addRoleToUser("ouss94","ADMIN");
        userService.addRoleToUser("ouss94","USER");
        userService.addRoleToUser("amy96","USER");
        userService.addRoleToUser("saf94","ADMIN");

    }
}
