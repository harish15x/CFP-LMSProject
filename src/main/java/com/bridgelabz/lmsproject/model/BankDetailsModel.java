package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bankdetails")
public class BankDetailsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private String branch;
    private Double accountHolderName;
    private String email;
    private String creatorUser;
    private String updatedUser;
    private LocalDateTime createdDateTime;
    private LocalDateTime updateddateTime;

    public BankDetailsModel(BankDetailsDTO bankDetailsDTO){

        this.accountNumber = bankDetailsDTO.getAccountNumber();
        this.branch = bankDetailsDTO.getBranch();
        this.accountHolderName = bankDetailsDTO.getAccountHolderName();
        this.email = bankDetailsDTO.getEmail();
        this.creatorUser = bankDetailsDTO.getCreatorUser();
        this.updatedUser = bankDetailsDTO.getUpdatedUser();
        this.createdDateTime = LocalDateTime.now();
        this.updateddateTime = LocalDateTime.now();
    }

    public BankDetailsModel() {

    }
}
