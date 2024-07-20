package com.BasicSpringBootProject2.service.impl;

import com.BasicSpringBootProject2.Dto.EmployeeDto;
import com.BasicSpringBootProject2.Entity.Employee;
//import com.BasicSpringBootProject2.Mapper.EmployeeMapper;
import com.BasicSpringBootProject2.Repository.EmployeeRepository;
import com.BasicSpringBootProject2.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //covert EmployeeDto to Employee Dto  using EmployeeMapper methods.

//        Employee employee = EmployeeMapper.EmployeeDtoToEmployee(employeeDto);

        //shortest way of mapping from dto to entity type using ModelMapper and its methods.
        Employee employee = modelMapper.map(employeeDto,Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

//        EmployeeDto savedEmployeeToEmployeeDto = EmployeeMapper.EmployeeToEmployeeDto(savedEmployee);

        EmployeeDto savedEmployeeToEmployeeDto = modelMapper.map(savedEmployee,EmployeeDto.class);

        return savedEmployeeToEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Integer empId) {
        Optional<Employee> optionalEmployee= employeeRepository.findById(empId);
        Employee employee = optionalEmployee.get();

//        return EmployeeMapper.EmployeeToEmployeeDto(employee) ;
        return modelMapper.map(employee,EmployeeDto.class) ;
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

//        List<EmployeeDto> employeeDtoList = employeeList.stream().map(EmployeeMapper::EmployeeToEmployeeDto)
//                                            .collect(Collectors.toList());

        //using Model Mapper

        List<EmployeeDto> employeeDtoList = employeeList.stream().map((employee)->modelMapper.map(employee,EmployeeDto.class))
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

//        return EmployeeMapper.EmployeeToEmployeeDto(UpdatedEmployee);

        return modelMapper.map(UpdatedEmployee,EmployeeDto.class);
    }

    @Override
    public String deleteEmployee(Integer empId) {
        employeeRepository.deleteById(empId);
        return "Employee deleted successfully with Id :- "+empId;
    }
}
