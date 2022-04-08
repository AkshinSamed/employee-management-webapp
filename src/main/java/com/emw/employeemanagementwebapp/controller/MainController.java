package com.emw.employeemanagementwebapp.controller;

import com.emw.employeemanagementwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login()
    {
        return "login";

    }
}
