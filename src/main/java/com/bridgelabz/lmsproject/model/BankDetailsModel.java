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
    private String emailId;
    private String ifsccode;
    private LocalDateTime createdDateTime;
    private LocalDateTime updateddateTime;

    public BankDetailsModel(BankDetailsDTO bankDetailsDTO){

        this.id = bankDetailsDTO.getId();
        this.accountNumber = bankDetailsDTO.getAccountNumber();
        this.branch = bankDetailsDTO.getBranch();
        this.accountHolderName = bankDetailsDTO.getAccountHolderName();
        this.emailId = bankDetailsDTO.getEmailId();
        this.ifsccode = bankDetailsDTO.getIfsccode();
        this.createdDateTime = LocalDateTime.now();
        this.updateddateTime = LocalDateTime.now();

    }

    public BankDetailsModel() {

    }
}
