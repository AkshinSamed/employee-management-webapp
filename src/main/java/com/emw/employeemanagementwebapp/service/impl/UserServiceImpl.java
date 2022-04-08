package com.emw.employeemanagementwebapp.service.impl;

import com.emw.employeemanagementwebapp.dto.UserRegistrationDTO;
import com.emw.employeemanagementwebapp.model.Role;
import com.emw.employeemanagementwebapp.model.User;
import com.emw.employeemanagementwebapp.repository.UserRepository;
import com.emw.employeemanagementwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(UserRegistrationDTO registrationDTO) {
        return userRepository
                .save(new User(registrationDTO.getFirstName(),
                               registrationDTO.getLastName(),
                               registrationDTO.getEmail(),
                               passwordEncoder.encode(registrationDTO.getPassword()),
                               List.of(new Role("ROLE_USER"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                                                                      user.getPassword(),
                                                                      mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
    }
}
