package com.MarketPlace.Repository;

import com.MarketPlace.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

     Optional<Admin> findByAdminUsername(String adminUsername);

     Optional<Admin> findByMobileNumber( String mobileNumber);




}
