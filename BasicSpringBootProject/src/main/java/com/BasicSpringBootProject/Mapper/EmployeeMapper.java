package com.BasicSpringBootProject.Mapper;

import com.BasicSpringBootProject.Dto.EmployeeDto;
import com.BasicSpringBootProject.Entity.Employee;

public class EmployeeMapper {
    public static Employee EmployeeDtoToEmployee(EmployeeDto employeeDto){
        //Using Setter and Getter Mapping
//        Employee employee =new Employee();
//        employee.setId(employeeDto.getId());
//        employee.setName(employeeDto.getName());
//        employee.setEmail(employeeDto.getEmail());
//        employee.setSalary(employeeDto.getSalary());

        //Using Parametrized Constructor Mapping
        Employee employee =new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.getEmail(), employeeDto.getSalary());
        return employee;
    }

    public static EmployeeDto EmployeeToEmployeeDto(Employee employee){

        EmployeeDto employeeDto =new EmployeeDto(employee.getId(), employee.getName(), employee.getEmail(), employee.getSalary());

        return employeeDto;
    }
}
