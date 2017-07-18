package com.danielcudnik.publishinghouse.controller;

import com.danielcudnik.MyServerException;
import com.danielcudnik.base.dto.ResponseDTO;
import com.danielcudnik.publishinghouse.dto.PublishingHouseDTO;
import com.danielcudnik.publishinghouse.service.IPublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bidzis on 7/17/2017.
 */
@RestController
@RequestMapping(value = "/bookstore/publishing_houses")
public class PublishingHouseController {

    private IPublishingHouseService publishingHouseService;

    @Autowired
    public PublishingHouseController(IPublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }

    //CREATE & EDIT
    @RequestMapping(value="/save",method = RequestMethod.POST, consumes ="application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<PublishingHouseDTO> savePublishingHouse(@RequestBody PublishingHouseDTO publishingHouseDTO){
        return new ResponseEntity<>(publishingHouseService.savePublishingHouse(publishingHouseDTO), HttpStatus.OK);
    }


    //READ
    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<PublishingHouseDTO>> getAllPublishingHouses(){
        return new ResponseEntity<>(publishingHouseService.getAllPublishingHouses(),HttpStatus.OK);
    }

    //UPDATE

    //DELETE
    @RequestMapping(value="/removeById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<ResponseDTO> deletePublishingHouse(@PathVariable("id") Long id){
        try {
            publishingHouseService.deletePublishingHouse(id);
            return new ResponseEntity<>(new ResponseDTO("Deleted"),HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }

    }

}
