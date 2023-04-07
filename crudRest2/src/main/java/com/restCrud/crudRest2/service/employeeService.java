package com.restCrud.crudRest2.service;

import com.restCrud.crudRest2.entity.Employee;

import java.util.List;

public interface employeeService {
    public List<Employee> findAllEmployees();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
