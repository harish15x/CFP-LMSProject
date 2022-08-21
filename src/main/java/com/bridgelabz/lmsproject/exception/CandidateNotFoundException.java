package com.bridgelabz.lmsproject.exception;

import com.bridgelabz.lmsproject.util.Response;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CandidateNotFoundException extends RuntimeException{
    public Response getErrorResponse;
    private int statusCode;
    private String statusMessage;

    public CandidateNotFoundException(int statusCode, String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
