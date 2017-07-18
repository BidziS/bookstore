package com.danielcudnik.books.dto;

import com.danielcudnik.authors.dto.AuthorDTO;
import com.danielcudnik.base.dto.BaseDTO;
import com.danielcudnik.publishinghouse.dto.PublishingHouseDTO;

import java.util.Date;

/**
 * Created by Bidzis on 7/17/2017.
 */
public class BookDTOCreate extends BaseDTO{

    private String title;

    private Date realaseDate;

    private double price;

    private Long authorId;

    private Long publishingHouseId;

    public BookDTOCreate() {
    }

    public BookDTOCreate(Long id, Date techDate, String title, Date realaseDate, double price, Long authorId, Long publishingHouseId) {
        super(id, techDate);
        this.title = title;
        this.realaseDate = realaseDate;
        this.price = price;
        this.authorId = authorId;
        this.publishingHouseId = publishingHouseId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPublishingHouseId() {
        return publishingHouseId;
    }

    public void setPublishingHouseId(Long publishingHouseId) {
        this.publishingHouseId = publishingHouseId;
    }
}
