package com.restCrud.crudRest2.service;

import com.restCrud.crudRest2.dao.employeeDAO;
import com.restCrud.crudRest2.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceImpl implements employeeService{

    private employeeDAO employeeDAO;

    @Autowired
    public serviceImpl(employeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAllEmployees() {
       return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        Employee employee1 = employeeDAO.save(employee);
        return employee1;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
