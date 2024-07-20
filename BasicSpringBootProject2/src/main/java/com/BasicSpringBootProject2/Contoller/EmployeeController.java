package com.BasicSpringBootProject2.Contoller;


import com.BasicSpringBootProject2.Dto.EmployeeDto;
import com.BasicSpringBootProject2.service.EmployeeService;
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
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Integer empId){
        EmployeeDto empDto = employeeService.getEmployeeById(empId);
        return new ResponseEntity(empDto, HttpStatus.OK);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> empDtoList = employeeService.getAllEmployee();
        return new ResponseEntity(empDtoList, HttpStatus.OK);
    }



    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto empDto = employeeService.updateEmployeeById(id,employeeDto);
        return new ResponseEntity(empDto, HttpStatus.OK);
    }


    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id){
        String response = employeeService.deleteEmployee(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }





}
