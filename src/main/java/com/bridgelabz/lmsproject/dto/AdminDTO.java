package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class AdminDTO {


    private String firstName;
    private String lastName;
    private String mobile;
    private String emailId;
    private String profilePath;
    private String status;
    private String password;

}
