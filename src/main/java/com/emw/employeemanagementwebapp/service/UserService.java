package com.emw.employeemanagementwebapp.service;

import com.emw.employeemanagementwebapp.dto.UserRegistrationDTO;
import com.emw.employeemanagementwebapp.model.User;

public interface UserService {
    User save(UserRegistrationDTO registrationDTO);
}
