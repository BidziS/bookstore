package com.danielcudnik.authors.service;

import com.danielcudnik.MyServerException;
import com.danielcudnik.authors.dto.AuthorDTO;

import java.util.List;

/**
 * Created by Bidzis on 7/18/2017.
 */
public interface IAuthorService {

    //CREATE & EDIT
    AuthorDTO saveAuthor(AuthorDTO authorDTO);

    //READ
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getAuthorById(Long id);

    //UPDATE


    //DELETE
    void deleteAuthor(Long id) throws MyServerException;

}
