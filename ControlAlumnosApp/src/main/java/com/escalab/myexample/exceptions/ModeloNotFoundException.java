package com.escalab.myexample.exceptions;

public class ModeloNotFoundException extends RuntimeException{
    public ModeloNotFoundException(String message) {
        super(message);
    }
}
