package com.happiestminds.controller;

import com.happiestminds.model.Employee;
import com.happiestminds.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
contains all mapping annotation
handles all the CRUD operation methods
 */

@RestController
public class EmployeeController {

    //object injection using autowired annotation
    @Autowired
    EmployeeService employeeService;


    //to get all details employee
    @GetMapping("/employees")
    private List getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    //get employee details using id
    @GetMapping("/employees/{id}")
    private Employee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }

    //to add new employee details
    @PostMapping("/employees")
    private ResponseEntity createEmployee(@RequestBody Employee employee){
        try{
            employeeService.saveOrUpdate(employee);

        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New Employee created with id " + employee.getId(), HttpStatus.CREATED );
    }

    //delete employee details using id
    @DeleteMapping("/employees/{id}")
    private ResponseEntity deleteById(@PathVariable("id")int id){
        try{
            employeeService.delete(id);
        }catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Employee deleted with id:" + id, HttpStatus.OK);
    }

    //to update or edit of existing employee details using employee id
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeService.getEmployeeById(id);
        updateEmployee.setId(employeeDetails.getId());
        updateEmployee.setFirstName(employeeDetails.getLastName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setSalary(employeeDetails.getSalary());
        employeeService.saveOrUpdate(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

}
