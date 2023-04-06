package com.restCrud.crudRest2.dao;

import com.restCrud.crudRest2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
