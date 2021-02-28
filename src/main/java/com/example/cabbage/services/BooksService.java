package com.example.cabbage.services;

import java.util.List;

import com.example.cabbage.objects.dao.Books;
import com.example.cabbage.objects.dto.ResponseDto;


public interface BooksService {
    ResponseDto create(Books book) throws Exception;

    Books get(Long id) throws Exception;

    ResponseDto update(Books book) throws Exception;

    ResponseDto delete(Long id) throws Exception;

    List<Books> getBooksByAuthor(Long authorId) throws Exception;

    List<Books> getBooksByPublisher(Long publisherId) throws Exception;

}
