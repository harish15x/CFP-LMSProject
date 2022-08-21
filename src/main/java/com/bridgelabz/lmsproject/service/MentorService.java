package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.MentorDTO;
import com.bridgelabz.lmsproject.exception.MentorNotFoundException;
import com.bridgelabz.lmsproject.model.MentorModel;
import com.bridgelabz.lmsproject.repository.MentorRepository;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService implements IMentorService{

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public MentorModel addMentor(MentorDTO mentorDTO) {
        MentorModel mentorModel = new MentorModel(mentorDTO);
        mentorRepository.save(mentorModel);
        return null;
    }

    @Override
    public MentorModel updateMentor(String token, MentorDTO mentorDTO, Long id) {
        Long userid = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent = mentorRepository.findById(id);
        if (isMentorPresent.isPresent()){
            isMentorPresent.get().setEmployeeId(mentorDTO.getEmployeeId());
            isMentorPresent.get().setFirstName(mentorDTO.getFirstName());
            isMentorPresent.get().setLastName(mentorDTO.getLastName());
            isMentorPresent.get().setMentorType(mentorDTO.getMentorType());
            isMentorPresent.get().setMentorRole(mentorDTO.getMentorRole());
            isMentorPresent.get().setMobileNumber(mentorDTO.getMobileNumber());
            isMentorPresent.get().setEmail(mentorDTO.getEmail());
            isMentorPresent.get().setExperienceYears(mentorDTO.getExperienceYears());
            isMentorPresent.get().setPreferredTime(mentorDTO.getPreferredTime());
            isMentorPresent.get().setStartDate(mentorDTO.getStartDate());
            isMentorPresent.get().setStatus(mentorDTO.getStatus());
            isMentorPresent.get().setMentorDescription(mentorDTO.getMentorDescription());
            isMentorPresent.get().setProfileImageURL(mentorDTO.getProfileImageURL());
            isMentorPresent.get().setCreatorUser(mentorDTO.getCreatorUser());
            isMentorPresent.get().setSupervisorId(mentorDTO.getSupervisorId());
            isMentorPresent.get().setCreatedTimeStamp(mentorDTO.getCreatedTimeStamp());
            isMentorPresent.get().setUpdatedTimeStamp(mentorDTO.getUpdatedTimeStamp());
            mentorRepository.save(isMentorPresent.get());
            return isMentorPresent.get();
        }
        throw new MentorNotFoundException(400, "Mentor not found");
    }

    @Override
    public List<MentorModel> getMentorData(String token) {
        List<MentorModel> getAllMentorData = mentorRepository.findAll();
        if (getAllMentorData.size() > 0){
            return getAllMentorData;
        }
        throw new MentorNotFoundException(400, "Mentor not found");
    }

    @Override
    public MentorModel deleteMentor(long id, String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent = mentorRepository.findById(userId);
        if (isMentorPresent.isPresent()){
            mentorRepository.save(isMentorPresent.get());
            return isMentorPresent.get();
        }
       throw new MentorNotFoundException(400,"Mentor not found");
    }

    @Override
    public List<MentorModel> getById(String employeeId) {
        List<MentorModel> isIdPresent = mentorRepository.findAllById(employeeId);
        if (isIdPresent.isEmpty()){
            throw new MentorNotFoundException(400,"Mentor does not found by ID ");
        } else{
        return isIdPresent;
        }
    }

}
