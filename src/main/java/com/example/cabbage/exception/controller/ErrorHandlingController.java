package com.example.cabbage.exception.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.cabbage.exception.CustomException;
import com.example.cabbage.exception.ExceptionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {
    private static final Logger log = LoggerFactory.getLogger(ErrorHandlingController.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> generalException(Exception e) throws Exception {
        ExceptionResponse eR = new ExceptionResponse();
        eR.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        eR.setMessage("Server Error! Something Went Wrong!");
        log.error("Genaral Error" + e.getMessage(), dateFormat.format(new Date()));
        log.info(e.getMessage(), e);

        System.out.println("Genaral Error" + e.getMessage());
        return new ResponseEntity<ExceptionResponse>(eR, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> specialException(CustomException e) throws Exception {
        ExceptionResponse eR = new ExceptionResponse();
        eR.setCode(e.getHttpStatus().value());
        eR.setMessage(e.getMessage());
        System.out.println(e.getMessage());
        log.info(e.getMessage(), e);
        return new ResponseEntity<ExceptionResponse>(eR, e.getHttpStatus());

    }

}
