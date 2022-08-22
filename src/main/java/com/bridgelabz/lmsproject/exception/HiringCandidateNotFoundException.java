package com.bridgelabz.lmsproject.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class HiringCandidateNotFoundException extends RuntimeException{
    private int statusCode;
    private String statusMessage;

    public HiringCandidateNotFoundException(int statusCode, String statusMessage){
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
