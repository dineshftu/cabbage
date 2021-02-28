package com.example.cabbage.services;

import com.example.cabbage.objects.dao.Authors;
import com.example.cabbage.objects.dto.ResponseDto;

public interface AuthorsService {
        ResponseDto create(Authors author) throws Exception;

        Authors get(Long id) throws Exception;

        ResponseDto update(Authors author) throws Exception;

        ResponseDto delete(Long id) throws Exception;
        

}
