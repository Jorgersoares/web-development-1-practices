package com.projetopweb1.learningdocs.domain.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
