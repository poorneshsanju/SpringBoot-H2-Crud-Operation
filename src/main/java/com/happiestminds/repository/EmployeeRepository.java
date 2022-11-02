package com.happiestminds.repository;

import com.happiestminds.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
Jpa repository it contains CRUD operation api methods
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
