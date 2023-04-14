package com.restCrud.crudRest2.dao;

import com.restCrud.crudRest2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //sort by lastname
    public List<Employee> findAllByOrderByFirstNameAsc();
}
