package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.TechStackDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.TechStackModel;
import com.bridgelabz.lmsproject.service.ITechStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("techstack")
public class TechStackController {

    @Autowired
    ITechStackService techStackService;

    @PutMapping("/addtechstack")
    public TechStackModel addTechStack(@Valid @RequestBody TechStackDTO techStackDTO){
        return techStackService.addTechStack(techStackDTO);
    }

    @PutMapping("update/{id}")
    public TechStackModel updateTechStack(@RequestHeader String token, @Valid @RequestParam TechStackDTO techStackDTO, @PathVariable long id){
        return techStackService.updateTechStack(token, techStackDTO, id);
    }

    @GetMapping("getteckstack")
    public List<TechStackModel> getTeckStackData(@RequestHeader String token){
        return techStackService.getTechStackData(token);
    }

    @DeleteMapping("deletetechstack")
    public  TechStackModel deleteTechStack(@PathVariable Long id){
        return techStackService.deleteTeckStack(id);
    }


}
