package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.dto.MentorDTO;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "mentor")
public class MentorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mentorid;
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

    public MentorModel(MentorDTO mentorDTO){
        this.mentorid = mentorDTO.getId();
        this.employeeId = mentorDTO.getEmployeeId();
        this.firstName = mentorDTO.getFirstName();
        this.lastName = mentorDTO.getLastName();
        this.mentorType = mentorDTO.getMentorType();
        this.mentorRole = mentorDTO.getMentorRole();
        this.mobileNumber = mentorDTO.getMobileNumber();
        this.email = mentorDTO.getEmail();
        this.experienceYears = mentorDTO.getExperienceYears();
        this.preferredTime = mentorDTO.getPreferredTime();
        this.startDate = mentorDTO.getStartDate();
        this.status = mentorDTO.getStatus();
        this.mentorDescription = mentorDTO.getMentorDescription();
        this.profileImageURL = mentorDTO.getProfileImageURL();
        this.profileImageURL = mentorDTO.getProfileImageURL();
        this.creatorUser = mentorDTO.getCreatorUser();
        this.supervisorId = mentorDTO.getSupervisorId();
        this.createdTimeStamp = mentorDTO.getCreatedTimeStamp();
        this.updatedTimeStamp = mentorDTO.getUpdatedTimeStamp();
    }

    public MentorModel() {

    }
}
