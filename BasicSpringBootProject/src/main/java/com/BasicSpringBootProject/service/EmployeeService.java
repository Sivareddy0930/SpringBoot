package com.BasicSpringBootProject.service;

import com.BasicSpringBootProject.Dto.EmployeeDto;
import com.BasicSpringBootProject.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employee);
    Employee getEmployeeById(Integer empId);

    List<Employee> getAllEmployee();

    Employee updateEmployeeById(Integer empId,Employee employee);

    String deleteEmployee(Integer empId);
}
