package com.example.cabbage.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.cabbage.exception.CustomException;
import com.example.cabbage.objects.dao.Authors;
import com.example.cabbage.objects.dao.Books;
import com.example.cabbage.objects.dao.Publishers;
import com.example.cabbage.objects.dto.ResponseDto;
import com.example.cabbage.repositories.BooksRepository;
import com.example.cabbage.services.AuthorsService;
import com.example.cabbage.services.BooksService;
import com.example.cabbage.services.PublishersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BooksServiceImpl implements BooksService {
    private BooksRepository booksRepository;
    private PublishersService publishersService;
    private AuthorsService authorsService;

    @Autowired
    public BooksServiceImpl(BooksRepository booksRepository, PublishersService publishersService, 
            AuthorsService authorsService) {
        this.booksRepository = booksRepository;
        this.publishersService = publishersService;
        this.authorsService = authorsService;

    }

    @Override
    public ResponseDto create(Books book) throws Exception {
        this.validate(book);
        book = this.booksRepository.save(book);
        return new ResponseDto("Book Saved Successfully with ID " + book.getId(), true);
    }

    @Override
    public Books get(Long id) throws Exception {
        if (id == null)
            throw new CustomException(HttpStatus.NOT_FOUND, "Book ID not provided!");

        try {
            return this.booksRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Book Does not Exist!");
        }
    }

    @Override
    public ResponseDto update(Books book) throws Exception {
        this.get(book.getId());
        this.validate(book);
        this.booksRepository.save(book);
        return new ResponseDto("Book Updated Successfully", true);
    }

    @Override
    public ResponseDto delete(Long id) throws Exception {
        Books books = this.get(id);
        this.booksRepository.delete(books);
        return new ResponseDto("Book Deleted Successfully", true);
    }

    @Override
    public List<Books> getBooksByAuthor(Long authorId) throws Exception {
        List<Books> books = this.booksRepository.findByAuthorId(authorId);
        return books;
    }

    @Override
    public List<Books> getBooksByPublisher(Long publisherId) throws Exception {
        List<Books> books = this.booksRepository.findByPublisherId(publisherId);
        return books;
    }

    private void validate(Books book) throws Exception {
        book.validate(book);
        this.authorsService.get(book.getAuthor().getId());
        this.publishersService.get(book.getPublisher().getId());
    }
   
    
}
