package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.dto.TechStackDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "teckstack")
public class TechStackModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String techName;
    private String creatorUser;
    private String imagePath;
    private String status;
    private LocalDateTime creatorStamp;


    public TechStackModel(TechStackDTO techStackDTO) {
        this.id = techStackDTO.getId();
        this.techName = techStackDTO.getTechName();
        this.creatorStamp = techStackDTO.getCreatorStamp();
        this.imagePath = techStackDTO.getImagePath();
        this.status = techStackDTO.getStatus();
        this.creatorUser = techStackDTO.getCreatorUser();

    }

    public TechStackModel() {

    }
}
