package com.danielcudnik.authors.repository;

import com.danielcudnik.authors.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bidzis on 7/18/2017.
 */
public interface IAuthorRepository extends JpaRepository<Author, Long> {
}
