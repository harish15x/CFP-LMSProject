package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MentorDTO {

    private Long id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String mentorType;
    private String mentorRole;
    private String mobileNumber;
    private String email;
    private String experienceYears;
    private String preferredTime;
    private LocalDate startDate;
    private String status;
    private String mentorDescription;
    private String profileImageURL;
    private int creatorUser;
    private long supervisorId;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;


}
