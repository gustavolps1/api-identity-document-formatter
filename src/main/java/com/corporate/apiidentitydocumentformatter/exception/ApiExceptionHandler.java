package com.corporate.apiidentitydocumentformatter.exception;

import com.corporate.apiidentitydocumentformatter.domain.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleBadRequestException(Exception exception) {
        return buildResponseEntity(
                exception.getMessage(),
                Collections.singletonList(exception.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(String message, List<String> errors) {
        ApiException apiError =
                ApiException.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .details(HttpStatus.BAD_REQUEST.getReasonPhrase())
                        .message(message)
                        .errors(errors)
                        .timestamp(LocalDateTime.now())
                        .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}