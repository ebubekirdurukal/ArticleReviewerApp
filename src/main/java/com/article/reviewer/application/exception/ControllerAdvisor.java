package com.article.reviewer.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoArticleFoundException.class)
    public ResponseEntity<Object> handleNoArticleFoundException() {
        return badRequestWithCustomMessage("No Articles found");
    }

    @ExceptionHandler(NoReviewFoundException.class)
    public ResponseEntity<Object> handleNoReviewFoundException() {
        return badRequestWithCustomMessage("No Reviews found");
    }

    private ResponseEntity<Object> badRequestWithCustomMessage(String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", message);
        body.put("reason", HttpStatus.BAD_REQUEST.getReasonPhrase());
        body.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
