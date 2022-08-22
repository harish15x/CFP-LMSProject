package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.dto.HiringCandidateDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "hiringcandidate")
public class HiringCandidateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String jobLocation;
    private String status;
    private String passedOutYear;
    private String creatorUser;
    private String candidateStatus;
    private LocalDateTime creationTimeStamp;
    private LocalDateTime updatedTimeStamp;

    public HiringCandidateModel(HiringCandidateDTO hiringCandidateDTO){
        this.id = hiringCandidateDTO.getId();
        this.cicId = hiringCandidateDTO.getCicId();
        this.fullName = hiringCandidateDTO.getFullName();
        this.email = hiringCandidateDTO.getEmail();
        this.mobileNum = hiringCandidateDTO.getMobileNum();
        this.hiredDate = hiringCandidateDTO.getHiredDate();
        this.degree = hiringCandidateDTO.getDegree();
        this.aggrPer = hiringCandidateDTO.getAggrPer();
        this.city = hiringCandidateDTO.getCity();
        this.state = hiringCandidateDTO.getState();
        this.jobLocation = hiringCandidateDTO.getJobLocation();
        this.status = hiringCandidateDTO.getStatus();
        this.passedOutYear = hiringCandidateDTO.getPassedOutYear();
        this.creatorUser = hiringCandidateDTO.getCreatorUser();
        this.candidateStatus = hiringCandidateDTO.getCandidateStatus();
        this.creationTimeStamp = LocalDateTime.now();
        this.updatedTimeStamp = LocalDateTime.now();

    }

    public HiringCandidateModel() {

    }
}
