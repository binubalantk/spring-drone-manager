package com.dronemanager.controller;

import com.dronemanager.exceptions.DroneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@SuppressWarnings("unused")
@ControllerAdvice
public class DroneExceptionController {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(value = DroneNotFoundException.class)
    public ResponseEntity<Object> exception(DroneNotFoundException exception, Locale locale) {

        return new ResponseEntity<>(messageSource.getMessage("exception.message", null, locale), HttpStatus.NOT_FOUND);
    }
}
