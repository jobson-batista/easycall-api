package com.tecnologiadevalor.easycall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ContactExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MessageError> globalException(Exception exception, WebRequest request) {
        exception.printStackTrace();
        MessageError message = new MessageError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getDescription(false),
                "Internal server error",
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ContactEmailAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<MessageError> contactEmailAlreadyExistsException(ContactEmailAlreadyExistsException contactEmailAlreadyExistsException, WebRequest request) {
        contactEmailAlreadyExistsException.printStackTrace();
        MessageError message = new MessageError(
                HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false),
                contactEmailAlreadyExistsException.getTitle(),
                contactEmailAlreadyExistsException.getDescription(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContactCellPhoneAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<MessageError> contactCellPhoneAlreadyExistsException(ContactCellPhoneAlreadyExistsException contactCellPhoneAlreadyExistsException, WebRequest request) {
        contactCellPhoneAlreadyExistsException.printStackTrace();
        MessageError message = new MessageError(
                HttpStatus.BAD_REQUEST.value(),
                request.getDescription(false),
                contactCellPhoneAlreadyExistsException.getTitle(),
                contactCellPhoneAlreadyExistsException.getDescription(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
