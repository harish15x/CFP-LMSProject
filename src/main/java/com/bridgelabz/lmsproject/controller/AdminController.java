package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.dto.AdminDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.service.IAdminService;
import com.bridgelabz.lmsproject.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

       @Autowired
       IAdminService adminService;

        @PostMapping("/addadmin")
        public AdminModel addAdmin(@Valid @RequestBody AdminDTO adminDTO){
                return adminService.addAdmin(adminDTO);
        }

        @PutMapping("update/{id}")
        public AdminModel updateAdmin(@RequestHeader String token, @Valid @RequestParam AdminDTO adminDTO, @PathVariable long id){
                return adminService.updateAdmin(id, token, adminDTO);
        }

        @GetMapping("getadmindata")
        public List<AdminModel> getAllAdmin(@RequestHeader String token){
                return adminService.getAdminData(token);
        }

        @DeleteMapping("deleteadmin/{id}")
        public AdminModel deleteAdmin(@PathVariable Long id, @RequestHeader String token){
                return adminService.getDeleteAdmin(id, token);
        }

        @PostMapping("login")
        public Response login(@RequestParam String email, @RequestParam String password){
                return adminService.login(email, password);
        }

        @PutMapping("changepassword")
        public AdminModel changePassword(@RequestHeader String token, @RequestParam String password){
                return adminService.changePassword(token, password);
        }

         @PutMapping("resetpassword")
          public AdminModel resetPassword(@RequestParam String emailId){
               return adminService.resetPassword(emailId);
        }


}
