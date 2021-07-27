package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
          userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Krzysztof", "Krzys", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Arnold", "Abasd", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Maciej", "POL", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Stanisław", "stas", "1234", new ArrayList<>()));

            userService.addRoleToUser("Krzys","ROLE_USER");
            userService.addRoleToUser("Krzys","ROLE_MANAGER");
            userService.addRoleToUser("Abasd","ROLE_USER");
            userService.addRoleToUser("POL","ROLE_USER");
            userService.addRoleToUser("POL","ROLE_ADMIN");
            userService.addRoleToUser("stas","ROLE_USER");
            userService.addRoleToUser("stas", "ROLE_SUPER_ADMIN");

        };
    }
}
