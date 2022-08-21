package com.bridgelabz.lmsproject.exception.candidateexceptionhandler;

import com.bridgelabz.lmsproject.exception.CandidateNotFoundException;
import com.bridgelabz.lmsproject.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CandiadateExceptionHandler {
    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<Response> handleHiringException(CandidateNotFoundException he) {
        Response response = new Response();
        response.setErrorCode(400);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
