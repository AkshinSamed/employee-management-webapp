package com.emw.employeemanagementwebapp.service;

import com.emw.employeemanagementwebapp.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeByID(Long id);
    void deleteEmployeeByID(Long id);

}
