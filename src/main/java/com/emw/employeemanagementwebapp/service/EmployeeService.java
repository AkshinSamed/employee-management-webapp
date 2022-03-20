package com.emw.employeemanagementwebapp.service;

import com.emw.employeemanagementwebapp.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeByID(Long id);
    void deleteEmployeeByID(Long id);
    Page<Employee> findPaginated(int pageNo, int pageSize);

}
