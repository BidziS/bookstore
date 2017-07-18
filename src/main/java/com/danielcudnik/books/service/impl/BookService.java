package com.danielcudnik.books.service.impl;

import com.danielcudnik.MyServerException;
import com.danielcudnik.authors.entity.Author;
import com.danielcudnik.authors.repository.IAuthorRepository;
import com.danielcudnik.books.dto.BookDTO;
import com.danielcudnik.books.dto.BookDTOCreate;
import com.danielcudnik.books.entity.Book;
import com.danielcudnik.books.repository.IBookRepository;
import com.danielcudnik.books.service.IBookService;
import com.danielcudnik.publishinghouse.entity.PublishingHouse;
import com.danielcudnik.publishinghouse.repository.IPublishingHouseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * Created by Bidzis on 7/18/2017.
 */
@Service
@Transactional
public class BookService implements IBookService {

    private IBookRepository bookRepository;
    private IAuthorRepository authorRepository;
    private IPublishingHouseRepository publishingHouseRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookService(IBookRepository bookRepository, IAuthorRepository authorRepository, IPublishingHouseRepository publishingHouseRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publishingHouseRepository = publishingHouseRepository;
        this.modelMapper = modelMapper;
    }

    //CREATE
    @Override
    public BookDTO saveBook(BookDTOCreate bookDTOCreate) throws MyServerException {
        Author author = bookDTOCreate.getAuthorId() == null ? null : authorRepository.findOne(bookDTOCreate.getAuthorId());
        if(author == null) throw new MyServerException("Author not found", HttpStatus.NOT_FOUND);
        PublishingHouse publishingHouse = bookDTOCreate.getPublishingHouseId() == null ? null : publishingHouseRepository.findOne(bookDTOCreate.getAuthorId());
        if(publishingHouse == null) throw new MyServerException("Publishing house not found", HttpStatus.NOT_FOUND);

        Book book = bookDTOCreate.getId() == null ? null : bookRepository.findOne(bookDTOCreate.getId());
        if(book == null){
            book = new Book(bookDTOCreate.getTitle(), bookDTOCreate.getRealaseDate(), bookDTOCreate.getPrice());
            book.setAuthor(author);
            book.setPublishingHouse(publishingHouse);
            return modelMapper.map(bookRepository.save(book), BookDTO.class);
        }
        book.setTechDate(new Date());
        book.setTitle(bookDTOCreate.getTitle());
        book.setRealaseDate(bookDTOCreate.getRealaseDate());
        book.setAuthor(author);
        book.setPublishingHouse(publishingHouse);
        return modelMapper.map(bookRepository.save(book), BookDTO.class);
    }

    //READ
    @Override
    public List<BookDTO> getAllBooks() {
        Type booksListType = new TypeToken<List<BookDTO>>() {}.getType();
        return modelMapper.map(bookRepository.findAll(), booksListType);
    }

    @Override
    public List<BookDTO> getBooksByAuthorId(Long authorId) {
        Type booksListType = new TypeToken<List<BookDTO>>() {}.getType();
        return modelMapper.map(bookRepository.findBooksByAuthorId(authorId), booksListType);
    }

    @Override
    public List<BookDTO> getBooksByPublishingHouseId(Long publishingHouseId) {
        Type booksListType = new TypeToken<List<BookDTO>>() {}.getType();
        return modelMapper.map(bookRepository.findBooksByPublishingHouseId(publishingHouseId), booksListType);
    }

    @Override
    public BookDTO getBookById(Long id) {
        return modelMapper.map(bookRepository.findOne(id), BookDTO.class);
    }

    //UPDATE


    //DELETE
    @Override
    public void deleteBook(Long id) throws MyServerException {
        Book book = bookRepository.findOne(id);
        if(book == null) throw new MyServerException("Book with this id not exists", HttpStatus.NOT_FOUND);
        try{
            bookRepository.delete(id);
        }catch (Exception e){
            throw new MyServerException("Error", HttpStatus.CONFLICT);
        }

    }
}
