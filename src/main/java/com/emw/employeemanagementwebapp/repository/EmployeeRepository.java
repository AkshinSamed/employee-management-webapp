package com.emw.employeemanagementwebapp.repository;

import com.emw.employeemanagementwebapp.model.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
