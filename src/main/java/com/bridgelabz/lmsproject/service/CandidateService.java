package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.exception.AdminNotFoundException;
import com.bridgelabz.lmsproject.exception.CandidateNotFoundException;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.repository.AdminRepository;
import com.bridgelabz.lmsproject.repository.CandidateRepository;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService{

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public CandidateModel addCandidate(CandidateDTO candidateDTO, String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()){
        CandidateModel candidateModel = new CandidateModel(candidateDTO);
        candidateModel.setCreationTimeStamp(LocalDateTime.now());
        candidateRepository.save(candidateModel);
        String body = "Candidate is added successfully with candidateId " + candidateModel.getCandidateId();
        String subject = "Candidate registration successfully";
        mailService.send(candidateModel.getEmail(), subject, body);
        return candidateModel;
        }
        throw new CandidateNotFoundException(400, "token wrong");
    }

    @Override
    public CandidateModel updadateCandidate(Long id, String token, CandidateDTO candidateDTO) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()){
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
            } else {
            throw new CandidateNotFoundException(400,"Candidate not found");
            }
        }
           throw new AdminNotFoundException(400, "token is wrong");
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
    public CandidateModel getCandidateStatus(long id, String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()){
            Optional<CandidateModel> isCandidatePresent = candidateRepository.findById(id);
             if (isCandidatePresent.isPresent()) {
                 return isCandidatePresent.get() ;
             } else {
                 throw new CandidateNotFoundException(400, "Candidate Not Found");
             }
       }
        throw new AdminNotFoundException(400, "token is wrong ");
   }

}