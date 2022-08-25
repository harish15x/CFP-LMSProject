package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    ICandidateService candidateService;

    @PostMapping("addcandidate")
    public CandidateModel addCandidate(@Valid @RequestBody CandidateDTO candidateDTO, @RequestHeader String token){
        return candidateService.addCandidate(candidateDTO, token);
    }

    @PutMapping("update/{id}")
    public CandidateModel updateCandidate(@RequestHeader String token, @Valid @RequestBody CandidateDTO candidateDTO, @PathVariable Long id){
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

    @GetMapping("getcandidatestatus/{id}")
    public CandidateModel getCandidateStatus(@PathVariable long id, @RequestHeader String token){
        return candidateService.getCandidateStatus(id, token);
    }


}
