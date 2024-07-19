package com.BasicSpringBootProject.Contoller;


import com.BasicSpringBootProject.Dto.EmployeeDto;
import com.BasicSpringBootProject.Entity.Employee;
import com.BasicSpringBootProject.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/Employees")//base url
public class EmployeeController {

    private EmployeeService employeeService;

    //createEmployee Api

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto empDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity(empDto, HttpStatus.CREATED);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer empId){
        Employee emp = employeeService.getEmployeeById(empId);
        return new ResponseEntity(emp, HttpStatus.OK);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> emp = employeeService.getAllEmployee();
        return new ResponseEntity(emp, HttpStatus.OK);
    }



    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Integer id, @RequestBody Employee employee){
        Employee emp = employeeService.updateEmployeeById(id,employee);
        return new ResponseEntity(emp, HttpStatus.OK);
    }


    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Integer id){
        String response = employeeService.deleteEmployee(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }





}
