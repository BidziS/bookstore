package com.danielcudnik.authors.service.impl;

import com.danielcudnik.MyServerException;
import com.danielcudnik.authors.dto.AuthorDTO;
import com.danielcudnik.authors.entity.Author;
import com.danielcudnik.authors.repository.IAuthorRepository;
import com.danielcudnik.authors.service.IAuthorService;
import com.danielcudnik.books.entity.Book;
import com.danielcudnik.books.repository.IBookRepository;
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
public class AuthorService implements IAuthorService {

    private IAuthorRepository authorRepository;
    private IBookRepository bookRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AuthorService(IAuthorRepository authorRepository, IBookRepository bookRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO saveAuthor(AuthorDTO authorDTO) {
        Author author = authorDTO.getId() == null ? null : authorRepository.findOne(authorDTO.getId());
        if (author == null){
            author = modelMapper.map(authorDTO, Author.class);
            return modelMapper.map(authorRepository.save(author), AuthorDTO.class);
        }
        author.setTechDate(new Date());
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        return modelMapper.map(authorRepository.save(author), AuthorDTO.class);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        Type authorsListType = new TypeToken<List<AuthorDTO>>() {}.getType();
        return modelMapper.map(authorRepository.findAll(), authorsListType);
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        return modelMapper.map(authorRepository.findOne(id), AuthorDTO.class);
    }

    @Override
    public void deleteAuthor(Long id) throws MyServerException {
        Author author = authorRepository.findOne(id);
        if(author == null) throw new MyServerException("Author with this id not exists", HttpStatus.NOT_FOUND);

        List<Book> authorBooks = bookRepository.findBooksByAuthorId(id);

        if(authorBooks.size() != 0){
            throw new MyServerException("You can not delete this author because he has a books assigned to him!", HttpStatus.NOT_ACCEPTABLE);
        }
        authorRepository.delete(id);

    }
}
