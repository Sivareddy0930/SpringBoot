package com.BasicSpringBootProject.Contoller;

import com.BasicSpringBootProject.Entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("Employee")//base url
public class EmployeeController {

//    @GetMapping("/employee")
//    public Employee getEmployee(){
//        Employee obj =new Employee(1,"emp1",40000.00);
//        return obj;
//    }


//    @GetMapping("/employee")
//    public ResponseEntity<Employee> getEmployee(){
//        Employee obj =new Employee(1,"emp100",40000.00);
//        return new ResponseEntity<>(obj,HttpStatus.OK);
//    }

//    @GetMapping("/employee")
//    public ResponseEntity<Employee> getEmployee(){
//        Employee obj =new Employee(1,"emp100",40000.00);
//        return ResponseEntity.ok(obj);
//    }


    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployee(){
        Employee obj =new Employee(1,"emp10000",40000.00);
        return ResponseEntity.ok().header("EmployeeData","kingu").body(obj);
    }



    @GetMapping("/employees")
    public List<Employee> getListOfEmployee(){

        ArrayList<Employee> al = new ArrayList<>();
        al.add(new Employee(1,"emp1",40000.00));
        al.add(new Employee(2,"emp2",30000.00));
        al.add(new Employee(3,"emp3",20000.00));
        al.add(new Employee(4,"emp4",60000.00));
        return al ;
    }

    //@PathVariable annotation
    //To bind  URI template variable to method variables
    //get value form URI template variable ======> {id}
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee obj =new Employee(id,"emp1",40000.00);
        return obj;
    }

    //multi path variables

    //http://localhost:8080/employees/2/siva
    @GetMapping("/employees/{id}/{employee-name}")
    public Employee getEmployeeByIdAndName(@PathVariable int id,@PathVariable("employee-name") String name){
        Employee obj =new Employee(id,name,40000.00);
        return obj;
    }


    //Rest Api with requestParams
    //used to bind the query parameters from URL to variables of method.
    //http://localhost:8080/employees/query?id=100
    @GetMapping("/employees/query")
    public Employee getEmployeeByRequestParam(@RequestParam int id){
        Employee obj =new Employee(id,"emp1",40000.00);
        return obj;
    }

    //multi QueryParameters
    //http://localhost:8080/employees/queryParams?id=100&name="Kinguu"
    @GetMapping("/employees/queryParams")
    public Employee getEmployeeByRequestParams(@RequestParam int id,@RequestParam String name){
        Employee obj =new Employee(id,name,40000.00);
        return obj;
    }

    // requestBody annotation.
    //it retrieves  the http request body  and automatically covert it into java object.

    @PostMapping("/employees/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getSalary());
        return employee;
    }



    @PutMapping("/employees/{id}/update")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        System.out.println(employee.getName());
        System.out.println(employee.getSalary());
        System.out.println("Employee Object updated with id "+id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){

        return ResponseEntity.ok("Deleted Employee successfully with id "+ id);
    }

}
