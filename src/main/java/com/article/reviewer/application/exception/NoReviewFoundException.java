package com.article.reviewer.application.exception;

public class NoReviewFoundException extends RuntimeException {

    public NoReviewFoundException() {
        super("No review is found with given parameters");
    }

}
