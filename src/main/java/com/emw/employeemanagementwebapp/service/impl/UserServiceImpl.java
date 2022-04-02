package com.emw.employeemanagementwebapp.service.impl;

import com.emw.employeemanagementwebapp.dto.UserRegistrationDTO;
import com.emw.employeemanagementwebapp.model.Role;
import com.emw.employeemanagementwebapp.model.User;
import com.emw.employeemanagementwebapp.repository.UserRepository;
import com.emw.employeemanagementwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserRegistrationDTO registrationDTO) {
        User user = new User(registrationDTO.getFirstName(),
                             registrationDTO.getLastName(),
                             registrationDTO.getEmail(),
                             registrationDTO.getPassword(),
                             List.of(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
