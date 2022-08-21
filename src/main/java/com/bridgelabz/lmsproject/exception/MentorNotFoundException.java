package com.bridgelabz.lmsproject.exception;

public class MentorNotFoundException extends RuntimeException{
    private int statusCode;
    private String statusMessage;

    public MentorNotFoundException(int statusCode, String statusMessage){
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
