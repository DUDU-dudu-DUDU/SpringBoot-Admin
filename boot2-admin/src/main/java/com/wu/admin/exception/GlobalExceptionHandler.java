package com.wu.admin.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
* 处理web的controller异常
* */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handleArithException(Exception e){
        return "login";
    }
}
