package com.restCrud.crudRest2.service;

import com.restCrud.crudRest2.dao.EmployeeRepository;
import com.restCrud.crudRest2.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceImpl implements employeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public serviceImpl(EmployeeRepository employeeDAO){
        this.employeeRepository = employeeDAO;
    }

    @Override
    public List<Employee> findAllEmployees() {
       return employeeRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()){
            employee = result.get();
        }else{
            throw new RuntimeException("Did not find employee id "+id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }

    //no need for transactional as jpa provides for us
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
