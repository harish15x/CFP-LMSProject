package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class AdminDTO {

    @Pattern(regexp = "[A-Z][a-zA-z]{2,}",message = "Invalid firstname")
    private String firstName;
    @Pattern(regexp = "[A-Z][a-zA-Z]{2,}", message = "Invalid lastname")
    private String lastName;
    @Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid number")
    private String mobile;
    @Pattern(regexp = "[a-z][A-Z a-z 0-9]+[@][a-z]+[.][a-z]{2,}", message = "Invalid Email")
    private String emailId;
    private String profilePath;
    private String status;
    private String password;

}
