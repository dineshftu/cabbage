package com.example.cabbage.services;


import com.example.cabbage.objects.dao.Publishers;
import com.example.cabbage.objects.dto.ResponseDto;

public interface PublishersService {
    ResponseDto create(Publishers publisher) throws Exception;

    Publishers get(Long id) throws Exception;

    ResponseDto update(Publishers publisher) throws Exception;

    ResponseDto delete(Long id) throws Exception;

}
