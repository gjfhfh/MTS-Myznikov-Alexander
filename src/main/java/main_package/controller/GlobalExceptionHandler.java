package main_package.controller;

import main_package.exception.BooksNotFoundException;
import main_package.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(BooksNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(BooksNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleUserNotFound(IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
