package com.bridgelabz.lmsproject.exception.bankdetailexceptionhandler;

import com.bridgelabz.lmsproject.exception.BankDetailsNotfoundException;
import com.bridgelabz.lmsproject.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankDetailExceptionHandler {

    @ExceptionHandler(BankDetailsNotfoundException.class)
    public ResponseEntity<Response> handleHiringException(BankDetailsNotfoundException he) {
        Response response = new Response();
        response.setErrorCode(400);
        response.setMessage("Admin not found");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
