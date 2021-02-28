package com.example.cabbage.services.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.cabbage.exception.CustomException;
import com.example.cabbage.objects.dao.Authors;
import com.example.cabbage.objects.dto.ResponseDto;
import com.example.cabbage.repositories.AuthorsRepository;
import com.example.cabbage.services.AuthorsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    private AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsServiceImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public ResponseDto create(Authors author) throws Exception {
        author = this.authorsRepository.save(author);
        return new ResponseDto("Author Saved Successfully with ID " + author.getId(), true);
    }

    @Override
    public Authors get(Long id) throws Exception {
        if (id == null)
            throw new CustomException(HttpStatus.NOT_FOUND, "Author ID not provided!");

        try {
            return this.authorsRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Author Does not Exist!");
        }
    }

    @Override
    public ResponseDto update(Authors author) throws Exception {
        this.get(author.getId());
        this.authorsRepository.save(author);
        return new ResponseDto("Author Updated Successfully", true);
    }

    @Override
    public ResponseDto delete(Long id) throws Exception {
        Authors authors = this.get(id);
        this.authorsRepository.delete(authors);
        return new ResponseDto("Author Deleted Successfully", true);
    }

}
