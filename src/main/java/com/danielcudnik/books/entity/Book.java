package com.danielcudnik.books.entity;

import com.danielcudnik.authors.entity.Author;
import com.danielcudnik.base.entity.Base;
import com.danielcudnik.publishinghouse.entity.PublishingHouse;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Bidzis on 7/17/2017.
 */
@Entity
@Table(name = "books")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_BOOKS_ID")
public class Book extends Base{

    private String title;

    @Column(name = "realase_date")
    private Date realaseDate;

    private double price;

    @OneToOne
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
    @NotNull
    private Author author;

    @OneToOne
    @JoinColumn(name = "PUBLISHING_HOUSE_ID", referencedColumnName = "ID")
    @NotNull
    private PublishingHouse publishingHouse;

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRealaseDate() {
        return realaseDate;
    }

    public void setRealaseDate(Date realaseDate) {
        this.realaseDate = realaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}
