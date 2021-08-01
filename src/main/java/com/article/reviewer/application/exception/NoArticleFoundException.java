package com.article.reviewer.application.exception;

public class NoArticleFoundException extends RuntimeException {

    public NoArticleFoundException() {
        super("No article is found with given parameters");
    }

}
