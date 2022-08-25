package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import com.bridgelabz.lmsproject.exception.AdminNotFoundException;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.repository.AdminRepository;
import com.bridgelabz.lmsproject.util.Response;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Override
    public AdminModel addAdmin(AdminDTO adminDTO) {
        AdminModel adminModel = new AdminModel(adminDTO);
        adminModel.setRegistereddate(LocalDateTime.now());
        adminRepository.save(adminModel);
        String body = "admin added sucessfully " + adminModel.getAdminId();
        String subject = "admin registration completed";
        mailService.send(adminModel.getEmailId(),body, subject);
        return adminModel;
    }

    @Override
    public AdminModel updateAdmin (long id, String token, AdminDTO adminDTO) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()) {
            Optional<AdminModel> isAdminsPresent = adminRepository.findById(id);
            if (isAdminsPresent.isPresent()){
            isAdminPresent.get().setFirstName(adminDTO.getFirstName());
            isAdminPresent.get().setLastName(adminDTO.getLastName());
            isAdminPresent.get().setMobile(adminDTO.getMobile());
            isAdminPresent.get().setEmailId(adminDTO.getEmailId());
            isAdminPresent.get().setProfilePath(adminDTO.getProfilePath());
            isAdminPresent.get().setStatus(adminDTO.getStatus());
            isAdminPresent.get().setUpdateddate(LocalDateTime.now());
            adminRepository.save(isAdminPresent.get());
            String body = "Admin is added " + isAdminPresent.get().getAdminId();
            String subject = "Admin registration complete";
            mailService.send(isAdminPresent.get().getEmailId(), subject, body);
            return isAdminsPresent.get();
        } else {
               throw new AdminNotFoundException(400, "Admin not found");
           }
        }
        throw new AdminNotFoundException(400, "token does not match");
    }

    @Override
    public List<AdminModel> getAdminData(String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()) {
            List<AdminModel> getalladmindata = adminRepository.findAll();
            if (getalladmindata.size() > 0) {
                return getalladmindata;
            } else {
            throw new AdminNotFoundException(400, "Admin not Found");
            }
        }
        throw new AdminNotFoundException(400,"token does not match");
    }

    @Override
    public AdminModel getDeleteAdmin(Long id, String token) {
        Long userId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(userId);
        if (isAdminPresent.isPresent()) {
            Optional<AdminModel> isAdminPresents = adminRepository.findById(id);
            if(isAdminPresents.isPresent()){
            adminRepository.save(isAdminPresent.get());
            return isAdminPresent.get();
            }else{
                throw new AdminNotFoundException(400, "Admin is not present ");
            }
        }
        throw new AdminNotFoundException(400, " Token does not match ");
    }

    @Override
    public Response login(String email, String password) {
        Optional<AdminModel> isEmailPresent = adminRepository.findByEmailId(email);
        if (isEmailPresent.isPresent()) {
             if (isEmailPresent.get().getPassword().equals(password)){
                String token = tokenUtil.createToken(isEmailPresent.get().getAdminId());
                return new Response("Login is sucessfull", 200, token);
            }
            throw new AdminNotFoundException(200, "password incorrect");
        }
        throw new AdminNotFoundException(400, "Not admi is present");
    }

    @Override
    public AdminModel changePassword(String token, String password) {
        Long id = tokenUtil.decodeToken(token);
        Optional<AdminModel> isIdPresent = adminRepository.findById(id);
        if(isIdPresent.isPresent()){
            isIdPresent.get().setPassword(password);
            adminRepository.save(isIdPresent.get());
            return isIdPresent.get();
        } else {
            throw new AdminNotFoundException(400, "token does not match");
        }
    }

    @Override
    public AdminModel resetPassword(String emailId) {
        Optional<AdminModel> isEmailPresent = adminRepository.findByEmailId(emailId);
        if(isEmailPresent.isPresent()){
            String token = tokenUtil.createToken(isEmailPresent.get().getAdminId());
            String url = "http://localhost:8085/lmsproject/changePassword";
            String subject = "reset password";
            String body = "For reset password click on this link" + url + "use this to reset password" + token;
            mailService.send(isEmailPresent.get().getEmailId(), body, subject);
            return isEmailPresent.get();
        }
       throw new AdminNotFoundException(400,"token wrong");
        }

}
