package com.danielcudnik.books.dto;

import com.danielcudnik.authors.dto.AuthorDTO;
import com.danielcudnik.base.dto.BaseDTO;
import com.danielcudnik.publishinghouse.dto.PublishingHouseDTO;

import java.util.Date;

/**
 * Created by Bidzis on 7/18/2017.
 */
public class BookDTO extends BaseDTO {

    private String title;

    private Date realaseDate;

    private double price;

    private AuthorDTO author;

    private PublishingHouseDTO publishingHouse;

    public BookDTO() {
    }

    public BookDTO(Long id, Date techDate, String title, Date realaseDate, double price, AuthorDTO author, PublishingHouseDTO publishingHouse) {
        super(id, techDate);
        this.title = title;
        this.realaseDate = realaseDate;
        this.price = price;
        this.author = author;
        this.publishingHouse = publishingHouse;
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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public PublishingHouseDTO getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouseDTO publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}
