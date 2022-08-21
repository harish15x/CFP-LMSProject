package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lmsprojectnew")
public class CandidateController {

    @Autowired
    ICandidateService candidateService;

    @PostMapping("addcandidate")
    public CandidateModel addCandidate(@RequestBody CandidateDTO candidateDTO){
        return candidateService.addCandidate(candidateDTO);
    }

    @PutMapping("update/{id}")
    public CandidateModel updateCandidate(@RequestHeader String token, @RequestBody CandidateDTO candidateDTO, @PathVariable Long id){
        return candidateService.updadateCandidate(id, token, candidateDTO);
    }

    @GetMapping("getcandidatedata")
    public List<CandidateModel> getAllCandidate(@RequestHeader String token){
        return candidateService.getCandidateData(token);
    }

    @DeleteMapping("deletecandidate")
    public CandidateModel deleteCandidate(@PathVariable long id, @RequestHeader String token){
        return candidateService.getDeleteCandidate(id, token);
    }

    @GetMapping("getcandidatestatus")
    public CandidateModel getCandidateStatus(@RequestHeader String token){
        return candidateService.getCandidateStatus(token);
    }


}
