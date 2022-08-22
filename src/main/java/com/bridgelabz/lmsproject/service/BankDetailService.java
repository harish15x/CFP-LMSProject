package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.BankDetailsDTO;
import com.bridgelabz.lmsproject.exception.AdminNotFoundException;
import com.bridgelabz.lmsproject.exception.BankDetailsNotfoundException;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.BankDetailsModel;
import com.bridgelabz.lmsproject.repository.AdminRepository;
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
    AdminRepository adminRepository;

    @Autowired
    BankDetailsRepository bankDetailsRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public BankDetailsModel addBankDetails(BankDetailsDTO bankDetailsDTO, String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()) {
            BankDetailsModel bankDetailsModel = new BankDetailsModel(bankDetailsDTO);
            bankDetailsModel.setCreatedDateTime(LocalDateTime.now());
            bankDetailsRepository.save(bankDetailsModel);
            String body = "Bank details are added " + bankDetailsModel.getId();
            String subject = "registration is successfull";
            mailService.send(bankDetailsModel.getEmail(), subject, body);
            return bankDetailsModel;
            }else{
            throw new AdminNotFoundException(400, "Token is entered wrong");
        }
    }

    @Override
    public BankDetailsModel updateBankDetails(String token, BankDetailsDTO bankDetailsDTO, Long id) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()){
            Optional<BankDetailsModel> isBankPresent = bankDetailsRepository.findById(id);
            if(isBankPresent.isPresent()){
            isBankPresent.get().setAccountNumber(bankDetailsDTO.getAccountNumber());
            isBankPresent.get().setBranch(bankDetailsDTO.getBranch());
            isBankPresent.get().setEmail(bankDetailsDTO.getEmail());
            isBankPresent.get().setAccountHolderName(bankDetailsDTO.getAccountHolderName());
            isBankPresent.get().setCreatorUser(bankDetailsDTO.getCreatorUser());
            isBankPresent.get().setUpdatedUser(bankDetailsDTO.getUpdatedUser());
            isBankPresent.get().setCreatedDateTime(bankDetailsDTO.getCreatedDateTime());
            isBankPresent.get().setUpdateddateTime(bankDetailsDTO.getUpdateddateTime());
            bankDetailsRepository.save(isBankPresent.get());
            String body = "Bank details are added " + isBankPresent.get().getId();
            String subject = "Bank registration sucess";
            mailService.send(isBankPresent.get().getEmail(), subject, body);
            return isBankPresent.get();
            }else{
                throw new AdminNotFoundException(400 , "Bank details not found");
            }
        }
        throw new AdminNotFoundException(400, "Token is wrong ");
    }

    @Override
    public List<BankDetailsModel> getBankDetails(String token) {
        Long bankId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(bankId);
        if (isAdminPresent.isPresent()){
        List<BankDetailsModel> getBankDetails = bankDetailsRepository.findAll();
        if (getBankDetails.size() > 0 ){
            return getBankDetails;
          }
            throw new AdminNotFoundException(400, "Bank details does not found ");
        }
          throw new AdminNotFoundException(400, "Token is wrong");
    }

    @Override
    public BankDetailsModel deleteBankDetails(Long id, String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()){
        Optional<BankDetailsModel> isBankDetails = bankDetailsRepository.findById(id);
        if (isBankDetails.isPresent()){
            bankDetailsRepository.save(isBankDetails.get());
            return isBankDetails.get();
        }else {
            throw new AdminNotFoundException(400, "deletion is sucess");
        }
        }
        throw new BankDetailsNotfoundException(400,"token is wrong");
    }
}


