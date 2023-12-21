package com.restCrud.crudRest2.rest;

import com.restCrud.crudRest2.entity.Employee;
import com.restCrud.crudRest2.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class restController {

//    private employeeDAO employeeDAO;

    private employeeService employeeService;
    @Autowired
    public restController(employeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
       return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null){
            throw new RuntimeException("Employee not found "+id);
        }
        return employee;
    }

    //add mapping for post /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
       employee.setId(0);
       Employee employee1 = employeeService.save(employee);
       return employee1;
    }

    //add mapping for put - update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }


    //add mapping for delete for delete employee
    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        employeeService.deleteById(id);
        return employee;
    }

}
