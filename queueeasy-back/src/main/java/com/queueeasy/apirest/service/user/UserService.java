package com.queueeasy.apirest.service.user;

import com.queueeasy.apirest.controller.DTO.UserDTO;
import com.queueeasy.apirest.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserDTO> findAll();

    public Optional<UserDTO> findById(Long id);

    public Optional<UserDTO> findByUsername(String email);

    public UserModel save(UserModel user);

    public void deleteById(Long id);

    public boolean existsByUsername(String email);
}
