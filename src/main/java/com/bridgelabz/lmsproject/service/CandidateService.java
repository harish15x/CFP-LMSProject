package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.exception.CandidateNotFoundException;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.repository.CandidateRepository;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService{
    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public CandidateModel addCandidate(CandidateDTO candidateDTO) {
        CandidateModel candidateModel = new CandidateModel(candidateDTO);
        candidateRepository.save(candidateModel);
        return candidateModel;
    }

    @Override
    public CandidateModel updadateCandidate(Long id, String token, CandidateDTO candidateDTO) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<CandidateModel>  isCandidatePresent = candidateRepository.findById(id);
        if (isCandidatePresent.isPresent()){
            isCandidatePresent.get().setCicId(candidateDTO.getCicId());
            isCandidatePresent.get().setFullName(candidateDTO.getFullName());
            isCandidatePresent.get().setEmail(candidateDTO.getEmail());
            isCandidatePresent.get().setMobileNum(candidateDTO.getMobileNum());
            isCandidatePresent.get().setHireDate(candidateDTO.getHiredDate());
            isCandidatePresent.get().setDegree(candidateDTO.getDegree());
            isCandidatePresent.get().setAggrPer(candidateDTO.getAggrPer());
            isCandidatePresent.get().setCity(candidateDTO.getCity());
            isCandidatePresent.get().setState(candidateDTO.getState());
            isCandidatePresent.get().setPreferredJobLocation(candidateDTO.getPreferredJobLocation());
            isCandidatePresent.get().setStatus(candidateDTO.getStatus());
            isCandidatePresent.get().setPassedOutYear(candidateDTO.getPassedOutYear());
            isCandidatePresent.get().setCreatorUser(candidateDTO.getCreatorUser());
            isCandidatePresent.get().setCandidateStatus(candidateDTO.getCandidateStatus());
            isCandidatePresent.get().setCreationTimeStamp(candidateDTO.getCreationTimeStamp());
            isCandidatePresent.get().setUpdatedTimeStamp(candidateDTO.getUpdatedTimeStamp());
            candidateRepository.save(isCandidatePresent.get());
            return isCandidatePresent.get();
        }
        throw new CandidateNotFoundException(400,"Candidate not found");
    }

    @Override
    public List<CandidateModel> getCandidateData(String token) {
        List<CandidateModel> getallcandidatedata = candidateRepository.findAll();
        if (getallcandidatedata.size() > 0) {
            return getallcandidatedata;
        }
        throw new CandidateNotFoundException(400, "Candidate Not Found");
    }

    @Override
    public CandidateModel getDeleteCandidate(long id, String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<CandidateModel> isCandidatePresent = candidateRepository.findById(userId);
        if (isCandidatePresent.isPresent()) {
            candidateRepository.save(isCandidatePresent.get());
            String body = "Candidate has been deleted: " + isCandidatePresent.get().getCandidateId();
            String subject = "candidate has been deleted successfully";
            mailService.send(isCandidatePresent.get().getEmail(), body, subject);
            return isCandidatePresent.get();
        }
        throw new CandidateNotFoundException(400, "Candidate does not found");
    }

    @Override
    public CandidateModel getCandidateStatus(String token) {
        List<CandidateModel> getallcandidatestatus = candidateRepository.findAll();
        if (getallcandidatestatus.size() > 0) {
            return getCandidateStatus(token);
        }
        throw new CandidateNotFoundException(400, "Candidate Not Found");
    }
}



