package com.bridgelabz.lmsproject.controller;


import com.bridgelabz.lmsproject.dto.MentorDTO;
import com.bridgelabz.lmsproject.model.MentorModel;
import com.bridgelabz.lmsproject.service.IMentorService;
import com.bridgelabz.lmsproject.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Mentor")
public class MentorController {

    @Autowired
    IMentorService mentorService;

        @PostMapping("/addmentor")
        public MentorModel addMentor(@Valid @RequestBody MentorDTO mentorDTO){
            return mentorService.addMentor(mentorDTO);
        }

        @PutMapping("update/{id}")
        public MentorModel updateMentor(@RequestHeader String token, @RequestBody MentorDTO mentorDTO, @PathVariable Long id){
            return mentorService.updateMentor(token, mentorDTO, id);
        }

        @GetMapping("getmentordata")
        public List<MentorModel> getMentorData(@RequestHeader String token){
            return mentorService.getMentorData(token);
        }

        @DeleteMapping("deletementor")
        public MentorModel deleteMentor(@PathVariable long id, @RequestHeader String token){
            return mentorService.deleteMentor(id, token);
        }

//        @GetMapping("uploadfile")
//        public MentorModel getdBYId (@RequestHeader ){
//            return mentorService.getBYId()
//
//        }

}
