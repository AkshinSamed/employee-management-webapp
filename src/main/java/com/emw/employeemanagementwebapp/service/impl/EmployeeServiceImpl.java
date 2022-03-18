package com.emw.employeemanagementwebapp.service.impl;

import com.emw.employeemanagementwebapp.model.Employee;
import com.emw.employeemanagementwebapp.repository.EmployeeRepository;
import com.emw.employeemanagementwebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
