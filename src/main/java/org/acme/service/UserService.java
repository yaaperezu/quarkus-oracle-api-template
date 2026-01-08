package org.acme.service;

import org.acme.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {

    public List<UserEntity> getAllUsers() {
        return UserEntity.listAll();
    }

    @Transactional
    public UserEntity createUser(UserEntity user) {
        // Persiste el objeto directamente en la base de datos Oracle
        user.persist();
        return user;
    }
}