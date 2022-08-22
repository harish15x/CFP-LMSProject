package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.TechStackDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.TechStackModel;

import java.util.List;

public interface ITechStackService {
    TechStackModel addTechStack(TechStackDTO techStackDTO);

    TechStackModel updateTechStack(String token, TechStackDTO techStackDTO, long id);

    List<TechStackModel> getTechStackData(String token);

    TechStackModel deleteTeckStack(Long id);
}
