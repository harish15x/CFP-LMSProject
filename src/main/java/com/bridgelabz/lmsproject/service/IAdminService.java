package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.util.Response;

import java.util.List;

public interface IAdminService {
    AdminModel addAdmin(AdminDTO adminDTO);

    AdminModel updateAdmin(long id, String token, AdminDTO adminDTO);

    List<AdminModel> getAdminData(String token);

    AdminModel getDeleteAdmin(Long id, String token);

    Response login(String email, String password);

    AdminModel changePassword(String token, String password);

    AdminModel resetPassword(String emailId);
}
