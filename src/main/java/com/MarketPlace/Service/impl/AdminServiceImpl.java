package com.MarketPlace.Service.impl;

import com.MarketPlace.Entity.Admin;
import com.MarketPlace.Entity.CurrentUserSession;
import com.MarketPlace.Exception.AdminException;
import com.MarketPlace.Exception.LoginException;
import com.MarketPlace.Repository.AdminRepo;
import com.MarketPlace.Repository.CurrentUserSessionRepo;
import com.MarketPlace.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private CurrentUserSessionRepo currentUserSessionRepo;


    public Admin signUpAdmin(Admin admin) throws AdminException {

        Optional<Admin> existAdminByUsername = adminRepo.findByAdminUsername(admin.getAdminUsername());

        Optional<Admin> existAdminByMobileNum = adminRepo.findByMobileNumber(admin.getMobileNumber());

        if (existAdminByMobileNum.isPresent()) {
            throw new AdminException("Admin already exist with this mobile number =>" + admin.getMobileNumber());

        }

        if (existAdminByUsername.isPresent()){
            throw new AdminException("Admin already exist with this user name =>" + admin.getAdminUsername());
        }else {
            return adminRepo.save(admin);
        }


    }

    @Override
    public Admin updateAdminDetails(Admin admin, String key) throws AdminException, LoginException {

        CurrentUserSession loggedInUser = currentUserSessionRepo.findByUniqueId(key);

        if (loggedInUser==null){
            throw new LoginException("To update admin details please login first");
        }

        if (admin.getAdminId()==loggedInUser.getUserId() && loggedInUser.getAdmin()){
            adminRepo.save(admin);

        }else {
            throw new AdminException("Provided admin details are incorrect please check " +
                    "admin ID and other details and try again");

        }


        return admin;
    }


}
