package com.BasicSpringBootProject2.service;

import com.BasicSpringBootProject2.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employee);
    EmployeeDto getEmployeeById(Integer empId);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployeeById(Integer empId,EmployeeDto employeeDto);

    String deleteEmployee(Integer empId);
}
