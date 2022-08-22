package com.bridgelabz.lmsproject.model;


import com.bridgelabz.lmsproject.dto.AdminDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table (name = "admintable")
public class AdminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;
    private String firstName;
    private String lastName;
    private String mobile;
    private String emailId;
    private String profilePath;
    private String status;
    private String password;
    private LocalDateTime registereddate;
    private LocalDateTime updateddate;

    public AdminModel(AdminDTO adminDTO){

        this.firstName = adminDTO.getFirstName();
        this.lastName = adminDTO.getLastName();
        this.mobile = adminDTO.getMobile();
        this.emailId = adminDTO.getEmailId();
        this.profilePath = adminDTO.getProfilePath();
        this.status = adminDTO.getStatus();
        this.password = adminDTO.getPassword();

    }

    public AdminModel() {

    }
}
