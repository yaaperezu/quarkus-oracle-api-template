package org.acme.service;

import org.acme.dto.UserDTO;
import org.acme.entity.UserEntity;
import org.acme.mapper.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        List<UserEntity> entities = UserEntity.listAll();
        return userMapper.toDTOList(entities);
    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity entity = userMapper.toEntity(userDTO);
        entity.persist();
        return userMapper.toDTO(entity);
    }
}