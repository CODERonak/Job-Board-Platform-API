package com.project.JobBoardAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.JobBoardAPI.exceptions.custom.*;

// Global exception handler for the application
@RestControllerAdvice
public class GlobalExceptionHandler {

        // NotFound Exception for handling not found errors
        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<ErrorResponse> handleNotFoundException(
                        NotFoundException ex) {
                ErrorResponse error = new ErrorResponse(
                                HttpStatus.NOT_FOUND.value(),
                                HttpStatus.NOT_FOUND.getReasonPhrase(),
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        // AlreadyExists Exception for handling already exists errors
        @ExceptionHandler(AlreadyExistsException.class)
        public ResponseEntity<ErrorResponse> handleAlreadyExistsException(
                        AlreadyExistsException ex) {
                ErrorResponse error = new ErrorResponse(
                                HttpStatus.CONFLICT.value(),
                                HttpStatus.CONFLICT.getReasonPhrase(),
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }

        // InvalidCredentials Exception for handling invalid credentials errors
        @ExceptionHandler(InvalidCredentials.class)
        public ResponseEntity<ErrorResponse> handleInvalidCredentials(
                        InvalidCredentials ex) {
                ErrorResponse error = new ErrorResponse(
                                HttpStatus.UNAUTHORIZED.value(),
                                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        }

        // AccessDenied Exception for handling access denied errors
        @ExceptionHandler(AccessDeniedException.class)
        public ResponseEntity<ErrorResponse> handleAccessDeniedException(
                        AccessDeniedException ex) {
                ErrorResponse error = new ErrorResponse(
                                HttpStatus.FORBIDDEN.value(),
                                HttpStatus.FORBIDDEN.getReasonPhrase(),
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
        }

}
