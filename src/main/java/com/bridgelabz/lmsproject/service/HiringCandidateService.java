package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.HiringCandidateDTO;
import com.bridgelabz.lmsproject.exception.HiringCandidateNotFoundException;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import com.bridgelabz.lmsproject.repository.HiringCandidateRepository;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HiringCandidateService implements IHiringCandidateService {

    @Autowired
    HiringCandidateRepository hiringCandidateRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public HiringCandidateModel addHiringCandidate(HiringCandidateDTO hiringCandidateDTO) {
        HiringCandidateModel hiringCandidateModel = new HiringCandidateModel();
        hiringCandidateModel.setCreationTimeStamp(LocalDateTime.now());
        hiringCandidateRepository.save(hiringCandidateModel);
        return hiringCandidateModel;
    }

    @Override
    public HiringCandidateModel updateHiringCandidate(String token, HiringCandidateDTO hiringCandidateDTO, Long id) {
        Optional<HiringCandidateModel> isHiringCandidatePresent = hiringCandidateRepository.findById(id);
        if (isHiringCandidatePresent.isPresent()){
            isHiringCandidatePresent.get().setCicId(hiringCandidateDTO.getCicId());
            isHiringCandidatePresent.get().setFullName(hiringCandidateDTO.getCicId());
            isHiringCandidatePresent.get().setEmail(hiringCandidateDTO.getEmail());
            isHiringCandidatePresent.get().setMobileNum(hiringCandidateDTO.getMobileNum());
            isHiringCandidatePresent.get().setHiredDate(hiringCandidateDTO.getHiredDate());
            isHiringCandidatePresent.get().setDegree(hiringCandidateDTO.getDegree());
            isHiringCandidatePresent.get().setAggrPer(hiringCandidateDTO.getAggrPer());
            isHiringCandidatePresent.get().setCity(hiringCandidateDTO.getCity());
            isHiringCandidatePresent.get().setState(hiringCandidateDTO.getState());
            isHiringCandidatePresent.get().setJobLocation(hiringCandidateDTO.getJobLocation());
            isHiringCandidatePresent.get().setStatus(hiringCandidateDTO.getStatus());
            isHiringCandidatePresent.get().setPassedOutYear(hiringCandidateDTO.getPassedOutYear());
            isHiringCandidatePresent.get().setCreatorUser(hiringCandidateDTO.getCreatorUser());
            isHiringCandidatePresent.get().setCandidateStatus(hiringCandidateDTO.getCandidateStatus());
            isHiringCandidatePresent.get().setCreationTimeStamp(hiringCandidateDTO.getCreationTimeStamp());
            isHiringCandidatePresent.get().setUpdatedTimeStamp(hiringCandidateDTO.getUpdatedTimeStamp());
            hiringCandidateRepository.save(isHiringCandidatePresent.get());
            return isHiringCandidatePresent.get();
        }
        throw new HiringCandidateNotFoundException(400,"HiredCandidate not found");
    }

    @Override
    public List<HiringCandidateModel> getHiringCandidate(String token) {
        List<HiringCandidateModel> getHiringCandidate = hiringCandidateRepository.findAll();
        if (getHiringCandidate.size() > 0){
            return getHiringCandidate;
        }
        throw new HiringCandidateNotFoundException(400, "Hired Candidate does not found");
    }

    @Override
    public HiringCandidateModel deleteHiringCandidate(long id, String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<HiringCandidateModel> isHiringCandidatePrsent = hiringCandidateRepository.findById(id);
        if (isHiringCandidatePrsent.isPresent()){

        }
        return null;
    }


}
