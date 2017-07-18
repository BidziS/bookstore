package com.danielcudnik.publishinghouse.service.impl;

import com.danielcudnik.MyServerException;
import com.danielcudnik.books.entity.Book;
import com.danielcudnik.books.repository.IBookRepository;
import com.danielcudnik.publishinghouse.dto.PublishingHouseDTO;
import com.danielcudnik.publishinghouse.entity.PublishingHouse;
import com.danielcudnik.publishinghouse.repository.IPublishingHouseRepository;
import com.danielcudnik.publishinghouse.service.IPublishingHouseService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * Created by Bidzis on 7/17/2017.
 */
@Service
@Transactional
public class PublishingHouseService implements IPublishingHouseService {

    private IPublishingHouseRepository publishingHouseRepository;
    private IBookRepository bookRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PublishingHouseService(IPublishingHouseRepository publishingHouseRepository, IBookRepository bookRepository, ModelMapper modelMapper) {
        this.publishingHouseRepository = publishingHouseRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    //CREATE
    @Override
    public PublishingHouseDTO savePublishingHouse(PublishingHouseDTO publishingHouseDTO) {
        PublishingHouse publishingHouse = publishingHouseDTO.getId() == null ? null : publishingHouseRepository.findOne(publishingHouseDTO.getId());
        if (publishingHouse == null){
            publishingHouse = modelMapper.map(publishingHouseDTO, PublishingHouse.class);
            return modelMapper.map(publishingHouseRepository.save(publishingHouse), PublishingHouseDTO.class);
        }
        publishingHouse.setTechDate(new Date());
        publishingHouse.setName(publishingHouseDTO.getName());
        return modelMapper.map(publishingHouseRepository.save(publishingHouse), PublishingHouseDTO.class);
    }

    //READ
    @Override
    public List<PublishingHouseDTO> getAllPublishingHouses() {
        Type publishingHousesListType = new TypeToken<List<PublishingHouseDTO>>() {}.getType();
        return modelMapper.map(publishingHouseRepository.findAll(), publishingHousesListType);
    }

    @Override
    public PublishingHouseDTO getPublishingHouseById(Long id) {
        return modelMapper.map(publishingHouseRepository.findOne(id), PublishingHouseDTO.class);
    }

    //UPDATE

    //DELETE
    @Override
    public void deletePublishingHouse(Long id) throws MyServerException {
        PublishingHouse publishingHouse = publishingHouseRepository.findOne(id);
        if(publishingHouse == null) throw new MyServerException("Publishing house with this id not exists", HttpStatus.NOT_FOUND);

        List<Book> publishingHouseBooks = bookRepository.findBooksByPublishingHouseId(id);

        if(publishingHouseBooks.size() != 0){
            throw new MyServerException("You can not delete this publishing house because it has a issued books!", HttpStatus.NOT_ACCEPTABLE);
        }

        publishingHouseRepository.delete(id);
    }
}
