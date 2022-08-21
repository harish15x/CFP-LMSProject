package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CandidateDTO {

    private long id;
    private String cicId;
    private String fullName;
    private String email;
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
