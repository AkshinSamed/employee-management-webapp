package com.emw.employeemanagementwebapp.controller;

import com.emw.employeemanagementwebapp.dto.UserRegistrationDTO;
import com.emw.employeemanagementwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO(){
        return new UserRegistrationDTO();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "registration";
    }


    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDTO registrationDTO){
        userService.save(registrationDTO);
        return "redirect:/registration?success";
    }
}
