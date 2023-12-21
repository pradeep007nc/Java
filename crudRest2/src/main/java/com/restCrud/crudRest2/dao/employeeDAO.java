package com.restCrud.crudRest2.dao;

import com.restCrud.crudRest2.entity.Employee;

import java.util.List;

public interface employeeDAO {

    public List<Employee> getAllEmployees();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

}
