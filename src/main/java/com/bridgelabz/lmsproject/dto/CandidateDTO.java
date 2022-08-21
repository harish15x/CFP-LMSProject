package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class CandidateDTO {

    private long id;
    private String cicId;
    @Pattern(regexp = "[A-Z][a-zA-z]{2,}",message = "Invalid firstname")
    private String fullName;
    @Pattern(regexp = "[a-z][A-Z a-z 0-9]+[@][a-z]+[.][a-z]{2,}", message = "Invalid Email")
    private String email;
    @Pattern(regexp = "[6-9][0-9]{9}", message = "Invalid number")
    private String mobileNum;
    private String hiredDate;
    private String degree;
    private Double aggrPer;
    private String city;
    private String state;
    private String preferredJobLocation;
    private String status;
    private String passedOutYear;
    private String creatorUser;
    private String candidateStatus;
    private LocalDateTime creationTimeStamp;
    private LocalDateTime updatedTimeStamp;

}
