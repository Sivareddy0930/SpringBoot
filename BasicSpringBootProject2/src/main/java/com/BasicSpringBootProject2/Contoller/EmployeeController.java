package com.BasicSpringBootProject2.Contoller;


import com.BasicSpringBootProject2.Dto.EmployeeDto;
import com.BasicSpringBootProject2.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/Employees")//base url
@Tag(
        name = "Employee management",
        description = "CRUD REST APIs for Employee management"
)
public class EmployeeController {

    private EmployeeService employeeService;

    //createEmployee Api

    @Operation(
            summary = "create Employee Rest Api",
            description = "create Employee Rest Api used to save employee object in Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http status 201 Created"
    )
    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto empDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity(empDto, HttpStatus.CREATED);
    }


    @Operation(
            summary = "getEmployeeById  Rest Api",
            description = "getEmployeeById  Rest Api used to get employee object by id from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 Success"
    )
    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Integer empId){
        EmployeeDto empDto = employeeService.getEmployeeById(empId);
        return new ResponseEntity(empDto, HttpStatus.OK);
    }

    @Operation(
            summary = "getAllEmployee  Rest Api",
            description = "getAllEmployee  Rest Api used to get All employee object  from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 Success"
    )
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> empDtoList = employeeService.getAllEmployee();
        return new ResponseEntity(empDtoList, HttpStatus.OK);
    }



    @Operation(
            summary = "updateEmployee Rest Api",
            description = "updateEmployee  Rest Api used to update employee object in the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 Success"
    )
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Integer id, @RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto empDto = employeeService.updateEmployeeById(id,employeeDto);
        return new ResponseEntity(empDto, HttpStatus.OK);
    }


    @Operation(
            summary = "deleteEmployee Rest Api",
            description = "deleteEmployee Rest Api used to delete employee object in the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 Success"
    )

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id){
        String response = employeeService.deleteEmployee(id);
        return new ResponseEntity(response, HttpStatus.OK);
    }





}
