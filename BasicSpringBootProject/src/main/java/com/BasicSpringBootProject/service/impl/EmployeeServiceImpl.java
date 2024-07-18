package com.BasicSpringBootProject.service.impl;

import com.BasicSpringBootProject.Entity.Employee;
import com.BasicSpringBootProject.Repository.EmployeeRepository;
import com.BasicSpringBootProject.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        Optional<Employee> optionalEmployee= employeeRepository.findById(empId);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployeeById(Integer empId, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        Employee emp =optionalEmployee.get();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setSalary(employee.getSalary());
        employeeRepository.save(emp);
        return emp;
    }

    @Override
    public String deleteEmployee(Integer empId) {
        employeeRepository.deleteById(empId);
        return "Employee deleted successfully with Id :- "+empId;
    }
}
