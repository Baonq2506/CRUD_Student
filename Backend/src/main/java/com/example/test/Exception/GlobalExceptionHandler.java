package com.example.test.Exception;


import com.example.test.Model.Student;
import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public String nullPointer (Exception e){
        e.printStackTrace();
        return "Loi value null";
    }

    @ExceptionHandler(ArithmeticException.class)
    public String IOPointer (Exception e){
        e.printStackTrace();
        return "Loi chia cho 0";
    }

    @ExceptionHandler({SQLException.class,EmptyResultDataAccessException.class})
    public String sqlPointer (Exception e){
        LOGGER.info(String.valueOf(e));
        e.printStackTrace();
        return "Loi cau thuc thi  sql";
    }



}
