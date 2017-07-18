package com.danielcudnik.publishinghouse.service;

import com.danielcudnik.MyServerException;
import com.danielcudnik.publishinghouse.dto.PublishingHouseDTO;

import java.util.List;

/**
 * Created by Bidzis on 7/17/2017.
 */
public interface IPublishingHouseService {

    //CREATE & EDIT
    PublishingHouseDTO savePublishingHouse(PublishingHouseDTO publishingHouseDTO);

    //READ
    List<PublishingHouseDTO> getAllPublishingHouses();
    PublishingHouseDTO getPublishingHouseById(Long id);

    //UPDATE


    //DELETE
    void deletePublishingHouse(Long id) throws MyServerException;

}
