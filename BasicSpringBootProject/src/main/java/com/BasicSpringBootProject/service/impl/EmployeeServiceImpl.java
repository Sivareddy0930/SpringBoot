package com.BasicSpringBootProject.service.impl;

import com.BasicSpringBootProject.Dto.EmployeeDto;
import com.BasicSpringBootProject.Entity.Employee;
import com.BasicSpringBootProject.Mapper.EmployeeMapper;
import com.BasicSpringBootProject.Repository.EmployeeRepository;
import com.BasicSpringBootProject.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //covert EmployeeDto to Employee Dto  using EmployeeMapper methods.
        Employee employee = EmployeeMapper.EmployeeDtoToEmployee(employeeDto);
       Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.EmployeeToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer empId) {
        Optional<Employee> optionalEmployee= employeeRepository.findById(empId);
        Employee employee = optionalEmployee.get();
        return EmployeeMapper.EmployeeToEmployeeDto(employee) ;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
//        List<EmployeeDto> employeeDtoList =new ArrayList<>();
//        for (Employee emp: employeeList) {
//            EmployeeDto empDto = EmployeeMapper.EmployeeToEmployeeDto(emp);
//            employeeDtoList.add(empDto);
//        }

        // using Java 8 streams.

        List<EmployeeDto> employeeDtoList = employeeList.stream().map(EmployeeMapper::EmployeeToEmployeeDto)
                                            .collect(Collectors.toList());


        return employeeDtoList;
    }

    @Override
    public EmployeeDto updateEmployeeById(Integer empId, EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        Employee employee =optionalEmployee.get();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setSalary(employeeDto.getSalary());
        Employee UpdatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.EmployeeToEmployeeDto(UpdatedEmployee);
    }

    @Override
    public String deleteEmployee(Integer empId) {
        employeeRepository.deleteById(empId);
        return "Employee deleted successfully with Id :- "+empId;
    }
}
