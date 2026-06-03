package dev.estudo.managerFoot.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.estudo.managerFoot.Controller.exception.ResourceAlreadyEsistsException;
import dev.estudo.managerFoot.Controller.exception.ResourceNotFoundException;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Data
    @Builder
    public static class ErrorResponser{
        private LocalDateTime timestamp;
        private int status;
        private String message;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Map<String,String> errors;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponser> handleResourceNotFound(ResourceNotFoundException ex){
        ErrorResponser error = ErrorResponser.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceAlreadyEsistsException.class)
    public ResponseEntity<ErrorResponser> handleResourceAlreadyExist(ResourceAlreadyEsistsException ex){
        ErrorResponser error = ErrorResponser.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .status(HttpStatus.CONFLICT.value())
                .build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponser> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> fieldErrors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorResponser error = ErrorResponser.builder()
                .timestamp(LocalDateTime.now())
                .message("Validation error")
                .status(HttpStatus.BAD_REQUEST.value())
                .errors(fieldErrors)
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponser> handleBadCredentialsException(BadCredentialsException ex){
        ErrorResponser error = ErrorResponser.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponser> handleAccessDeniedException(AccessDeniedException ex){
        ErrorResponser error = ErrorResponser.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .build();
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }
}
