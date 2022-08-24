package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import com.bridgelabz.lmsproject.exception.BankDetailsNotfoundException;
import com.bridgelabz.lmsproject.model.BankDetailsModel;
import com.bridgelabz.lmsproject.repository.BankDetailsRepository;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BankDetailService implements IBankDetailService {

    @Autowired
    BankDetailsRepository bankDetailsRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public BankDetailsModel addBankDetails(BankDetailsDTO bankDetailsDTO, String token) {

       BankDetailsModel bankDetailsModel = new BankDetailsModel(bankDetailsDTO);
       bankDetailsDTO.setCreatedDateTime(LocalDateTime.now());
       bankDetailsRepository.save(bankDetailsModel);
        String body = "admin is added sucessfully with admin id " + bankDetailsModel.getId();
        String subject = "admin registration successfully";
        mailService.send(bankDetailsModel.getEmailId(),body, subject);
        return bankDetailsModel;
    }

    @Override
    public BankDetailsModel updateBankDetails(String token, BankDetailsDTO bankDetailsDTO, Long id) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<BankDetailsModel> isBankDetailPresent = bankDetailsRepository.findById(id);
        if (isBankDetailPresent.isPresent()){
            isBankDetailPresent.get().setId(bankDetailsDTO.getId());
            isBankDetailPresent.get().setAccountNumber(bankDetailsDTO.getAccountNumber());
            isBankDetailPresent.get().setBranch(bankDetailsDTO.getBranch());
            isBankDetailPresent.get().setAccountHolderName(bankDetailsDTO.getAccountHolderName());
            isBankDetailPresent.get().setCreatorUser(bankDetailsDTO.getCreatorUser());
            isBankDetailPresent.get().setUpdatedUser(bankDetailsDTO.getUpdatedUser());
            isBankDetailPresent.get().setCreatedDateTime(bankDetailsDTO.getCreatedDateTime());
            isBankDetailPresent.get().setUpdateddateTime(bankDetailsDTO.getUpdateddateTime());
            bankDetailsRepository.save(isBankDetailPresent.get());
        }
        throw new BankDetailsNotfoundException(400, "bank details does not found");
    }

    @Override
    public List<BankDetailsModel> getBankDetails(String token) {
        Long bankId = tokenUtil.decodeToken(token);
        Optional<BankDetailsModel> isgetBankDetails = bankDetailsRepository.findById(bankId);
        if (isgetBankDetails.isPresent()){
        List<BankDetailsModel> getBankDetails = bankDetailsRepository.findAll();
        if (getBankDetails.size() > 0 ){
            return getBankDetails;
          }
            throw new BankDetailsNotfoundException(400, "Bank details does not found ");
        }
          throw new BankDetailsNotfoundException(400, "Bank details does not found");
    }

    @Override
    public BankDetailsModel deleteBankDetails(Long id) {
        Optional<BankDetailsModel> isBankDetails = bankDetailsRepository.findById(id);
        if (isBankDetails.isPresent()){
            bankDetailsRepository.save(isBankDetails.get());
            return isBankDetails.get();
        }
        throw new BankDetailsNotfoundException(400,"Bank does not found");
    }


}
