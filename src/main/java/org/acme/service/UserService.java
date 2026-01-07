package org.acme.service;

import org.acme.dto.UserDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {
    // Simulación de base de datos en memoria
    private List<UserDTO> users = new ArrayList<>();

    public List<UserDTO> getAllUsers() {
        return users;
    }

    public UserDTO createUser(UserDTO user) {
        var newUser = new UserDTO(UUID.randomUUID(), user.username(), user.email(), user.role());
        users.add(newUser);
        return newUser;
    }
}