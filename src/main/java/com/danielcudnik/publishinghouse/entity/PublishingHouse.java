package com.danielcudnik.publishinghouse.entity;

import com.danielcudnik.base.entity.Base;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Bidzis on 7/17/2017.
 */
@Entity
@Table(name = "publishing_houses")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_PUBLISHING_HOUSE_ID")
public class PublishingHouse extends Base {

    private String name;

    public PublishingHouse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
