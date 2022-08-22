package com.bridgelabz.lmsproject.controller;


import com.bridgelabz.lmsproject.dto.HiringCandidateDTO;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import com.bridgelabz.lmsproject.service.IHiringCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("hiringcandidate")
public class HiringCandidateController {

    @Autowired
    IHiringCandidateService hiringCandidateService;

    @PostMapping("addhiringcandidate")
    public HiringCandidateModel addHiringCandidate(@Valid @RequestBody HiringCandidateDTO hiringCandidateDTO){
        return hiringCandidateService.addHiringCandidate(hiringCandidateDTO);
    }

    @PutMapping("update/{id}")
    public HiringCandidateModel upateHiringCandidate(@RequestHeader String token, @Valid @RequestParam HiringCandidateDTO hiringCandidateDTO, @PathVariable Long id){
        return hiringCandidateService.updateHiringCandidate(token ,hiringCandidateDTO, id);
    }

    @GetMapping("gethiringcandidate")
    public List<HiringCandidateModel> getHiringCandidate(@RequestBody String token){
        return hiringCandidateService.getHiringCandidate(token);
    }

    @DeleteMapping("deletehiringcandidate")
    public HiringCandidateModel deleteHiringCandidate(@PathVariable long id, @RequestBody String token){
        return hiringCandidateService.deleteHiringCandidate(id, token);
    }





}
