package com.danielcudnik.authors.dto;

import com.danielcudnik.base.dto.BaseDTO;

import java.util.Date;

/**
 * Created by Bidzis on 7/17/2017.
 */
public class AuthorDTO extends BaseDTO {

    private String firstName;
    private String lastName;

    public AuthorDTO() {
    }

    public AuthorDTO(Long id, Date techDate, String firstName, String lastName) {
        super(id, techDate);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

