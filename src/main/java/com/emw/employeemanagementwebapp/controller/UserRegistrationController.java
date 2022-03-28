package com.emw.employeemanagementwebapp.controller;

import com.emw.employeemanagementwebapp.dto.UserRegistrationDTO;
import com.emw.employeemanagementwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDTO registrationDTO){
        userService.save(registrationDTO);
        return "redirect:/registration?success";
    }
}
