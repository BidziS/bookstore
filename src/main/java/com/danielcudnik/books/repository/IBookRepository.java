package com.danielcudnik.books.repository;

import com.danielcudnik.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Bidzis on 7/18/2017.
 */
public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.author.id = ?1")
    List<Book> findBooksByAuthorId(Long id);

    @Query("SELECT b FROM Book b WHERE b.publishingHouse.id = ?1")
    List<Book> findBooksByPublishingHouseId(Long id);

}
