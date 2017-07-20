package com.danielcudnik.user.dto;

import com.danielcudnik.base.dto.BaseDTO;
import com.danielcudnik.role.dto.RoleDTO;

import java.util.Date;

public class UserDTO extends BaseDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private RoleDTO role;

    private Boolean isActive;

    public UserDTO() {
    }


}
