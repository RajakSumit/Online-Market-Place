package com.MarketPlace.Service;

import com.MarketPlace.Entity.Admin;
import com.MarketPlace.Exception.AdminException;
import com.MarketPlace.Exception.LoginException;

public interface AdminService {

    public Admin signUpAdmin(Admin admin) throws AdminException;


    public Admin updateAdminDetails(Admin admin , String key) throws AdminException, LoginException;


}
