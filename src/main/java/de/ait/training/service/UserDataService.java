package de.ait.training.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    @PreAuthorize("hasRole('ADMIN')")
    public String getAllUserData(){
        return "Секретные данные обо всех пользователях. Доступ только ADMIN";
    }

    @PreAuthorize("isAuthenticated()")
    public String getSelfData(String username){
        return "Персональные данные пользователя " + username;
    }

}