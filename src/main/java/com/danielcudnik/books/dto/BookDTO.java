package com.danielcudnik.books.dto;

import com.danielcudnik.authors.dto.AuthorDTO;
import com.danielcudnik.base.dto.BaseDTO;
import com.danielcudnik.publishinghouse.dto.PublishingHouseDTO;

import java.util.Date;

/**
 * Created by Bidzis on 7/17/2017.
 */
public class BookDTO extends BaseDTO{

    private String title;

    private Date realaseDate;

    private double price;

    private AuthorDTO authorDTO;

    private PublishingHouseDTO publishingHouseDTO;

    public BookDTO() {
    }

    public BookDTO(Long id, Date techDate, String title, Date realaseDate, double price, AuthorDTO authorDTO, PublishingHouseDTO publishingHouseDTO) {
        super(id, techDate);
        this.title = title;
        this.realaseDate = realaseDate;
        this.price = price;
        this.authorDTO = authorDTO;
        this.publishingHouseDTO = publishingHouseDTO;
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

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    public PublishingHouseDTO getPublishingHouseDTO() {
        return publishingHouseDTO;
    }

    public void setPublishingHouseDTO(PublishingHouseDTO publishingHouseDTO) {
        this.publishingHouseDTO = publishingHouseDTO;
    }
}
