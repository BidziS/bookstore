package com.danielcudnik.books.service;

import com.danielcudnik.MyServerException;
import com.danielcudnik.books.dto.BookDTO;
import com.danielcudnik.books.dto.BookDTOCreate;

import java.util.List;

/**
 * Created by Bidzis on 7/18/2017.
 */
public interface IBookService {

    //CREATE & EDIT
    BookDTO saveBook(BookDTOCreate bookDTOCreate) throws MyServerException;

    //READ
    List<BookDTO> getAllBooks();
    List<BookDTO> getBooksByAuthorId(Long authorId);
    List<BookDTO> getBooksByPublishingHouseId(Long publishingHouseId);
    BookDTO getBookById(Long id);

    //UPDATE


    //DELETE
    void deleteBook(Long id) throws MyServerException;

}
