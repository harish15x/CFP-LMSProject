package com.bridgelabz.lmsproject.exception.techstackexceptionhandler;

import com.bridgelabz.lmsproject.exception.TechStackNotFoundException;
import com.bridgelabz.lmsproject.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TechStackExceptionhandler {
    @ExceptionHandler(TypeNotPresentException.class)
    public ResponseEntity<Response> handleHiringException(TechStackNotFoundException he) {
        Response response = new Response();
        response.setErrorCode(400);
        response.setMessage("Admin not found");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
