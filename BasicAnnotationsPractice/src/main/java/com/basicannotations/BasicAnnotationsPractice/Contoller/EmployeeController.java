package com.basicannotations.BasicAnnotationsPractice.Contoller;

import com.basicannotations.BasicAnnotationsPractice.Entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public Employee getEmployee(){
        Employee obj =new Employee(1,"emp1",40000.00);
        return obj;
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


}
