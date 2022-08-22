package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "candidate")
public class CandidateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long candidateId;
    private String cicId;
    private String fullName;
    private String email;
    private String mobileNum;
    private String hireDate;
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

    public CandidateModel(CandidateDTO candidateDTO){

        this.cicId = candidateDTO.getCicId();
        this.fullName = candidateDTO.getFullName();
        this.email = candidateDTO.getEmail();
        this.mobileNum = candidateDTO.getMobileNum();
        this.hireDate = candidateDTO.getHiredDate();
        this.degree = candidateDTO.getDegree();
        this.aggrPer = candidateDTO.getAggrPer();
        this.city = candidateDTO.getCity();
        this.state = candidateDTO.getState();
        this.preferredJobLocation = candidateDTO.getPreferredJobLocation();
        this.status = candidateDTO.getStatus();
        this.passedOutYear = candidateDTO.getPassedOutYear();
        this.creatorUser = candidateDTO.getCreatorUser();
        this.candidateStatus = candidateDTO.getCandidateStatus();
        this.creationTimeStamp = candidateDTO.getCreationTimeStamp();
        this.updatedTimeStamp = candidateDTO.getUpdatedTimeStamp();

    }

    public CandidateModel() {

    }
}
