package de.ait.training.controller;

import de.ait.training.service.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class UserDataController {
    private final UserDataService userDataService;

    @GetMapping("/all")
    public String getAllData(){
        return userDataService.getAllUserData();
    }

    @GetMapping("/me")
    public String getCurrentUser(Authentication authentication){
        return userDataService.getSelfData(authentication.getName());
    }
}
