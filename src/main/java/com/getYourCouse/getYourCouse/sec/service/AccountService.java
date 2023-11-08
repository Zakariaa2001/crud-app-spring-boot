package com.getYourCouse.getYourCouse.sec.service;

import com.getYourCouse.getYourCouse.sec.entities.AppRole;
import com.getYourCouse.getYourCouse.sec.entities.AppUser;


public interface AccountService {

    AppUser addNewUser(String username, String password, String email, String confirmPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username,String role);
    void removeRoleFromUser(String username,String role);
    AppUser loadUserByUsername(String username);
}
