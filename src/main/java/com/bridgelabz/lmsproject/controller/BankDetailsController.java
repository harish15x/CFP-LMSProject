package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import com.bridgelabz.lmsproject.model.BankDetailsModel;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.service.IBankDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("bankdetails")
public class BankDetailsController {

    @Autowired
    IBankDetailService bankDetailService;

    @PostMapping("addbankdetails")
    public BankDetailsModel addBankDetails( @Valid @RequestBody BankDetailsDTO bankDetailsDTO, @RequestHeader String token){
        return bankDetailService.addBankDetails(bankDetailsDTO, token);
    }

    @PutMapping("update/{id}")
    public BankDetailsModel updateBankDetails(@RequestHeader String token, @Valid @RequestParam BankDetailsDTO bankDetailsDTO, @PathVariable Long id){
        return bankDetailService.updateBankDetails(token, bankDetailsDTO, id);
    }

    @GetMapping("getbankdetaildata")
    public List<BankDetailsModel> getBankDetails(@RequestHeader String token){
        return bankDetailService.getBankDetails(token);
    }

    @DeleteMapping("deletebankdetail/{id}")
    public BankDetailsModel deleteBankDetails(@PathVariable Long id, @RequestHeader String token){
        return bankDetailService.deleteBankDetails(id, token);
    }




}
