package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import com.bridgelabz.lmsproject.model.BankDetailsModel;
import com.bridgelabz.lmsproject.model.CandidateModel;

import java.util.List;

public interface IBankDetailService {

    BankDetailsModel addBankDetails(BankDetailsDTO bankDetailsDTO);

    BankDetailsModel updateBankDetails(String token, BankDetailsDTO bankDetailsDTO, Long id);

    List<BankDetailsModel> getBankDetails(String token);

    BankDetailsModel deleteBankDetails(Long id);
}
