package com.wiperi.novuscrm.exception;

import com.wiperi.novuscrm.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Result> handleDuplicateKeyException(DuplicateKeyException e) {

        // extract the entry name from the exception message
        var message = e.getMessage();
        var i = message.indexOf("Duplicate entry");
        var entryName = message.substring(i).split(" ")[2];

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(Result.error(entryName + " already exists"));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Result> handleServiceException(BusinessException e) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(Result.error(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> handleException(Exception e) {
        log.error("System error", e);
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Result.error("System error"));
    }
} 