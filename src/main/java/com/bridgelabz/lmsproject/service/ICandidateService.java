package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;

import java.util.List;

public interface ICandidateService {

    CandidateModel addCandidate(CandidateDTO candidateDTO, String token);

    CandidateModel updadateCandidate(Long id,String token, CandidateDTO candidateDTO);

    List<CandidateModel> getCandidateData(String token);

    CandidateModel getDeleteCandidate(long id, String token);

    CandidateModel getCandidateStatus(long id, String token);

}
