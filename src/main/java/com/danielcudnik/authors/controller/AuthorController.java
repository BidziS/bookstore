package com.danielcudnik.authors.controller;

import com.danielcudnik.MyServerException;
import com.danielcudnik.authors.dto.AuthorDTO;
import com.danielcudnik.authors.service.IAuthorService;
import com.danielcudnik.base.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bidzis on 7/18/2017.
 */
@RestController
@RequestMapping(value = "/bookstore/authors")
public class AuthorController {

    private IAuthorService authorService;

    @Autowired
    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    //CREATE & EDIT
    @RequestMapping(value="/save",method = RequestMethod.POST, consumes ="application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<AuthorDTO> saveAuthor(@RequestBody AuthorDTO authorDTO){
        return new ResponseEntity<>(authorService.saveAuthor(authorDTO), HttpStatus.OK);
    }


    //READ
    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(){
        return new ResponseEntity<>(authorService.getAllAuthors(),HttpStatus.OK);
    }

    //UPDATE

    //DELETE
    @RequestMapping(value="/removeById/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<ResponseDTO> deleteAuthor(@PathVariable("id") Long id){
        try {
            authorService.deleteAuthor(id);
            return new ResponseEntity<>(new ResponseDTO("Deleted"),HttpStatus.OK);
        }catch (MyServerException e){
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }

    }
}
