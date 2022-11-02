package com.happiestminds.service;

import com.happiestminds.model.Employee;
import com.happiestminds.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    //get all the employee details by using jpa repository method findall()
    public List getAllEmployees(){
        List employees = new ArrayList();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }

    //retrieve employee details by id using findById() method
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).get();
    }

    public void saveOrUpdate(Employee employee){
        employeeRepository.save(employee);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }
}
