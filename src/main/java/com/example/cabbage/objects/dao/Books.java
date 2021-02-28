package com.example.cabbage.objects.dao;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.cabbage.exception.CustomException;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Entity
@Data
public class Books {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Authors author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publishers publisher;

    public void validate(Books book) throws Exception {
        if (book.getAuthor() == null)
            throw new CustomException(HttpStatus.BAD_REQUEST, "Author Required!");

        if (book.getPublisher() == null)
            throw new CustomException(HttpStatus.BAD_REQUEST, "Publisher Required!");

        if (book.getName() == null)
            throw new CustomException(HttpStatus.BAD_REQUEST, "Name Required!");

        if (book.getPrice() == null)
            throw new CustomException(HttpStatus.BAD_REQUEST, "Price Required!");
    }
}
