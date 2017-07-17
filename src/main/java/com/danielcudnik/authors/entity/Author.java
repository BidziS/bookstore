package com.danielcudnik.authors.entity;

import com.danielcudnik.base.entity.Base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Bidzis on 7/17/2017.
 */
@Entity
@Table(name = "authors")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_AUTHOR_ID")
public class Author extends Base {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        super();
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