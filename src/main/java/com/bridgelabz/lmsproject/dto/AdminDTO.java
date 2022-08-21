package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class AdminDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-z\\s]{2,}$",message = "Invalid firstname")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid lastname")
    private String lastName;
    @Pattern(regexp = "^\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}$", message = "Invalid number")
    private int mobile;
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid Email")
    private String emailId;
    private String profilePath;
    private String status;
    private String password;
    private LocalDateTime registereddate;
    private LocalDateTime updateddate;

}
