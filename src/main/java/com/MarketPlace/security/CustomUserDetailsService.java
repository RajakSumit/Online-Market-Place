package com.MarketPlace.security;

import com.MarketPlace.Entity.Admin;
import com.MarketPlace.Repository.AdminRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepo.findByAdminUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found with username: " + username));
        return User.builder()
                .username(admin.getAdminUsername())
                .password(admin.getPassword())
                .roles("ADMIN") // Set roles or authorities as needed
                .build();


    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Admin> admin = adminRepo.findByAdminUsername(username).orElseThrow(()-> new UsernameNotFoundException(""))
//        return User.builder()
//                .username(admin.getAdminUsername())
//                .password(admin.getPassword())
//                .roles("ADMIN") // Set roles or authorities as needed
//                .build();;
//    }

}
