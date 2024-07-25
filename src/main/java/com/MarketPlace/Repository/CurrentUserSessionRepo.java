package com.MarketPlace.Repository;


import com.MarketPlace.Entity.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession,Integer> {

    public CurrentUserSession findByUniqueID(String uniqueID);


}

