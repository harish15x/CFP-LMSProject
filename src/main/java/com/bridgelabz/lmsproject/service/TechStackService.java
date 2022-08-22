package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.TechStackDTO;
import com.bridgelabz.lmsproject.exception.TechStackNotFoundException;
import com.bridgelabz.lmsproject.model.TechStackModel;
import com.bridgelabz.lmsproject.repository.TechStackRepository;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechStackService implements ITechStackService{

    @Autowired
    TechStackRepository techStackRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public TechStackModel addTechStack(TechStackDTO techStackDTO) {
        TechStackModel techStackModel = new TechStackModel(techStackDTO);
        techStackRepository.save(techStackModel);
        return techStackModel;
    }

    @Override
    public TechStackModel updateTechStack(String token, TechStackDTO techStackDTO, long id) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<TechStackModel> isTechStackPresent = techStackRepository.findById(id);
        if (isTechStackPresent.isPresent()){
            isTechStackPresent.get().setId(techStackDTO.getId());
            isTechStackPresent.get().setTechName(techStackDTO.getTechName());
            isTechStackPresent.get().setCreatorUser(techStackDTO.getCreatorUser());
            isTechStackPresent.get().setImagePath(techStackDTO.getImagePath());
            isTechStackPresent.get().setStatus(techStackDTO.getStatus());
            isTechStackPresent.get().setCreatorStamp(techStackDTO.getCreatorStamp());
            techStackRepository.save(isTechStackPresent.get());
            return isTechStackPresent.get();
        }
        throw new TechStackNotFoundException(400, " TechStack dose");
    }

    @Override
    public List<TechStackModel> getTechStackData(String token) {
        Long techId = tokenUtil.decodeToken(token);
        Optional<TechStackModel> isTechPresnt = techStackRepository.findById(techId);
        if (isTechPresnt.isPresent()){
            List<TechStackModel> getTeckStackData = techStackRepository.findAll();
            if (getTeckStackData.size() > 0 ){
                return getTeckStackData;
            }
            throw new TechStackNotFoundException(400, "TechStack not available");
        }
        throw new TechStackNotFoundException(400, "TechStack not available");
    }

    @Override
    public TechStackModel deleteTeckStack(Long id) {
        Optional<TechStackModel> isTechStackPresesnt = techStackRepository.findById(id);
        if (isTechStackPresesnt.isPresent()){
            techStackRepository.save(isTechStackPresesnt.get());
            return isTechStackPresesnt.get();
        }
        throw new TechStackNotFoundException(400, "TechStack does not found");
    }

}
