package com.bridgelabz.lmsproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TechStackDTO {

    private long id;
    private String techName;
    private String creatorUser;
    private String imagePath;
    private String status;
    private LocalDateTime creatorStamp;

}
