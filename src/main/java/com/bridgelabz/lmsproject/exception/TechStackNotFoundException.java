package com.bridgelabz.lmsproject.exception;

public class TechStackNotFoundException extends RuntimeException{
    private int statusCode;
    private String statusMessage;
    public TechStackNotFoundException(  int statusCode, String statusMessage){
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
