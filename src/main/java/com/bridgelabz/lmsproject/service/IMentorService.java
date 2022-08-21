package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.MentorDTO;
import com.bridgelabz.lmsproject.model.MentorModel;

import java.util.List;

public interface IMentorService {
    MentorModel addMentor(MentorDTO mentorDTO);

    MentorModel updateMentor(String token, MentorDTO mentorDTO, Long id);

    List<MentorModel> getMentorData(String token);

    MentorModel deleteMentor(long id, String token);
}
