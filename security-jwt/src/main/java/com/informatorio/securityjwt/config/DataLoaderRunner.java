package com.informatorio.securityjwt.config;

import com.informatorio.securityjwt.domain.Role;
import com.informatorio.securityjwt.domain.User;
import com.informatorio.securityjwt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Este runner solo ha sido creado para demostrar y testear el funcionamiento de carga de la
 * base de datos. Mas adelante tiene que ser borrado.
 */
@AllArgsConstructor
@Component
public class DataLoaderRunner implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.saveRole(new Role(null, "ROLE_USER"));
        userService.saveRole(new Role(null, "ROLE_MANAGER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));

        userService.saveUser(new User(null, "homero", "Homero Simpson", "1234", new ArrayList<>()));
        userService.saveUser(new User(null, "lenny", "Lenny Leonard", "1234", new ArrayList<>()));
        userService.saveUser(new User(null, "waylon", "Waylon Smithers", "1234", new ArrayList<>()));
        userService.saveUser(new User(null, "montgomery", "Montgomery Burns", "1234", new ArrayList<>()));

        userService.addRoleToUser("homero", "ROLE_USER");
        userService.addRoleToUser("lenny", "ROLE_USER");
        userService.addRoleToUser("waylon", "ROLE_MANAGER");
        userService.addRoleToUser("montgomery", "ROLE_USER");
        userService.addRoleToUser("montgomery", "ROLE_MANAGER");
        userService.addRoleToUser("montgomery", "ROLE_ADMIN");
    }
}
