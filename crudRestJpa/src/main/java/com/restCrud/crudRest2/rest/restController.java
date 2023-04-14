package com.restCrud.crudRest2.rest;

import com.restCrud.crudRest2.entity.Employee;
import com.restCrud.crudRest2.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class restController {

//    private employeeDAO employeeDAO;

    private employeeService employeeService;
    @Autowired
    public restController(employeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String employees(Model model){
        model.addAttribute("employees", employeeService.findAllEmployees());
        return "Employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model){
        //create a model attribute to bind the data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "Employees/Employee-form";
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

    //for thymeleaf
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/api/employees";
    }

    //add mapping for put - update employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    //for thymeleaf
    @GetMapping("/showFormForUpdate")
    public String showFromUpdate(@RequestParam("employeeId") int Id, Model model){
        Employee employee = employeeService.findById(Id);
        model.addAttribute("employee", employee);
        //send this to form
        return "Employees/Employee-form";
    }


    //add mapping for delete for delete employee
    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        employeeService.deleteById(id);
        return employee;
    }

    //for thymeleaf
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int Id){
        employeeService.deleteById(Id);
        return "redirect:/api/employees";
    }

}
