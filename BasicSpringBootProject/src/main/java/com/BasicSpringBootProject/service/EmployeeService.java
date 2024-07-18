package com.BasicSpringBootProject.service;

import com.BasicSpringBootProject.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Integer empId);

    List<Employee> getAllEmployee();

    Employee updateEmployeeById(Integer empId,Employee employee);

    String deleteEmployee(Integer empId);
}
