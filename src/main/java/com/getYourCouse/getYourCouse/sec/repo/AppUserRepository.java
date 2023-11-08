package com.getYourCouse.getYourCouse.sec.repo;

import com.getYourCouse.getYourCouse.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
