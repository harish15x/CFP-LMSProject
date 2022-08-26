package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BankDetailsDTO {

    private long id;
    private String accountNumber;
    private String branch;
    private Double accountHolderName;
    private String emailId;
    private String ifsccode;
    private String creatorUser;
    private String updatedUser;
    private LocalDateTime createdDateTime;
    private LocalDateTime updateddateTime;

}
