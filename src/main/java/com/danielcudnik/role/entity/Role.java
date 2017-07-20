package com.danielcudnik.role.entity;

import com.danielcudnik.base.entity.Base;
import com.danielcudnik.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_ROLE_ID")
public class Role extends Base{

    @Column(unique = true)
    private String name;

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
