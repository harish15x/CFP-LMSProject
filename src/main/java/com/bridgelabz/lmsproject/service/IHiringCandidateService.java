package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.HiringCandidateDTO;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;

import java.util.List;

public interface IHiringCandidateService {
    HiringCandidateModel addHiringCandidate(HiringCandidateDTO hiringCandidateDTO);


    HiringCandidateModel updateHiringCandidate(String token, HiringCandidateDTO hiringCandidateDTO, Long id);

    List<HiringCandidateModel> getHiringCandidate(String token);

    HiringCandidateModel deleteHiringCandidate(long id, String token);
}
