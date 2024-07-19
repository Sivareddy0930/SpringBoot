package com.BasicSpringBootProject.service;

import com.BasicSpringBootProject.Dto.EmployeeDto;
import com.BasicSpringBootProject.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employee);
    EmployeeDto getEmployeeById(Integer empId);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployeeById(Integer empId,EmployeeDto employeeDto);

    String deleteEmployee(Integer empId);
}
