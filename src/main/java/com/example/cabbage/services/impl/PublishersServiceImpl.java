package com.example.cabbage.services.impl;

import java.util.NoSuchElementException;

import com.example.cabbage.exception.CustomException;
import com.example.cabbage.objects.dao.Publishers;
import com.example.cabbage.objects.dto.ResponseDto;
import com.example.cabbage.repositories.PublishersRepository;
import com.example.cabbage.services.PublishersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PublishersServiceImpl implements PublishersService {
    private PublishersRepository publishersRepository;

    @Autowired
    public PublishersServiceImpl(PublishersRepository publishersRepository) {
        this.publishersRepository = publishersRepository;
    }

    @Override
    public ResponseDto create(Publishers publisher) throws Exception {
        publisher = this.publishersRepository.save(publisher);
        return new ResponseDto("Publisher Saved Successfully with ID " + publisher.getId(), true);
    }

    @Override
    public Publishers get(Long id) throws Exception {
        if (id == null)
            throw new CustomException(HttpStatus.NOT_FOUND, "Publisher ID not provided!");

        try {
            return this.publishersRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Publisher Does not Exist!");
        }
    }

    @Override
    public ResponseDto update(Publishers publisher) throws Exception {
        this.get(publisher.getId());
        this.publishersRepository.save(publisher);
        return new ResponseDto("Publisher Updated Successfully", true);
    }

    @Override
    public ResponseDto delete(Long id) throws Exception {
        Publishers publishers = this.get(id);
        this.publishersRepository.delete(publishers);
        return new ResponseDto("Publisher Deleted Successfully", true);
    }   
    
}
