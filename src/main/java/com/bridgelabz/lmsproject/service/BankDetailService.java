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
    BankDetailsRepository bankDetailsRepository;

    @Autowired
    AdminRepository adminRepository;

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
            bankDetailsDTO.setCreatedDateTime(LocalDateTime.now());
            bankDetailsRepository.save(bankDetailsModel);
            String body = "admin is added sucess" + bankDetailsModel.getId();
            String subject = "admin registration successfully";
            mailService.send(bankDetailsModel.getEmailId(), body, subject);
            return bankDetailsModel;
        }
        throw new AdminNotFoundException(400," token is wrong ");
    }

    @Override
    public BankDetailsModel updateBankDetails(String token, BankDetailsDTO bankDetailsDTO, Long id) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if(isAdminPresent.isPresent()){
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
            return isBankDetailPresent.get();
            } else {
            throw new BankDetailsNotfoundException(400,"bank does not found");
            }
        }
        throw new AdminNotFoundException(400, "token is wrong");
    }

    @Override
    public List<BankDetailsModel> getBankDetails(String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPrsent = adminRepository.findById(userId);
        if (isAdminPrsent.isPresent()){
        List<BankDetailsModel> getBankDetails = bankDetailsRepository.findAll();
        if (getBankDetails.size() > 0 ){
            return getBankDetails;
           }
            throw new BankDetailsNotfoundException(400, "Bank details does not found ");
        }
          throw new AdminNotFoundException(400, "Bank details does not found");
    }

    @Override
    public BankDetailsModel deleteBankDetails(Long id, String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()) {
            Optional<BankDetailsModel> isBankDetails = bankDetailsRepository.findById(id);
            if (isBankDetails.isPresent()) {
                bankDetailsRepository.save(isBankDetails.get());
                return isBankDetails.get();
            } else {
                throw new BankDetailsNotfoundException(400, "Bank does not found");
            }
        }
            throw new AdminNotFoundException(400, "Token is wrong");
        }

    }
