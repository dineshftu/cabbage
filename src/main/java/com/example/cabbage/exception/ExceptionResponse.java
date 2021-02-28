package com.example.cabbage.exception;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter public class ExceptionResponse {
    private int code;
    private String message;
}
