package com.danielcudnik.publishinghouse.dto;

import com.danielcudnik.base.dto.BaseDTO;

import java.util.Date;

/**
 * Created by Bidzis on 7/17/2017.
 */
public class PublishingHouseDTO extends BaseDTO {

    private String name;

    public PublishingHouseDTO() {
    }

    public PublishingHouseDTO(Long id, Date techDate, String name) {
        super(id, techDate);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
