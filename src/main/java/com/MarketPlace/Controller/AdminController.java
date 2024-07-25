package com.MarketPlace.Controller;

import com.MarketPlace.Entity.Admin;
import com.MarketPlace.Exception.AdminException;
import com.MarketPlace.Repository.AdminRepo;
import com.MarketPlace.Service.AdminService;
import com.MarketPlace.Service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/marketPlace/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // http://localhost:8080/MarketPlace/admin/signUpAdmin
    @PostMapping("/signUpAdmin")
    public ResponseEntity<?> signUpAdminHandler(@Valid @RequestBody Admin admin) throws AdminException{

        Admin savedUser = adminService.signUpAdmin(admin);
        return new ResponseEntity<>("Admin Registered Successfully", HttpStatus.OK);




    }



}
