package com.danielcudnik.books.controller;

import com.danielcudnik.MyServerException;
import com.danielcudnik.base.dto.ResponseDTO;
import com.danielcudnik.books.dto.BookDTO;
import com.danielcudnik.books.dto.BookDTOCreate;
import com.danielcudnik.books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bidzis on 7/18/2017.
 */
@RestController
@RequestMapping(value = "/bookstore/books")
public class BookController {

    private IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    //CREATE & EDIT
    @RequestMapping(value="/save",method = RequestMethod.POST, consumes ="application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTOCreate bookDTOCreate){
        try {
            return new ResponseEntity<>(bookService.saveBook(bookDTOCreate), HttpStatus.OK);
        } catch (MyServerException e) {
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }


    //READ
    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    //UPDATE

    //DELETE
    @RequestMapping(value="/removeById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<ResponseDTO> deleteBook(@PathVariable("id") Long id){
        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>(new ResponseDTO("Deleted"),HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }

    }
}
