package com.bridgelabz.lmsproject.exception.hiringexceptionhandler;

import com.bridgelabz.lmsproject.exception.HiringCandidateNotFoundException;
import com.bridgelabz.lmsproject.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HiringCandidateExceptionHandler {
    @ExceptionHandler(HiringCandidateNotFoundException.class)
    public ResponseEntity<Response> handleHiringException(HiringCandidateExceptionHandler he) {
        Response response = new Response();
        response.setErrorCode(400);
        response.setMessage("Admin not found");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
