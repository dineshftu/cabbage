package com.example.cabbage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter public class CustomException extends Exception{

    private static final Long serialVersionUID = 1L;

    // private int code;
    private String message;
    private HttpStatus httpStatus;

    public CustomException(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public CustomException(){

    }

    @Override
    public String getMessage() {
        return message;
    }

	public void setMessage(String string) {
	}
}