package com.danielcudnik.user.service;

import com.danielcudnik.MyServerException;
import com.danielcudnik.user.dto.UserDTO;

import java.util.List;

public interface UserService {
    //CREATE & EDIT
    UserDTO saveUser(UserDTO authorDTO);

    //READ
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO getUserByEmail(String email);

    //UPDATE
    UserDTO setRoleToUser();

    //DELETE
    void deleteUser(Long id) throws MyServerException;
}
