package com.dev.pradeep.SunbaseAssignment.Controller;

import com.dev.pradeep.SunbaseAssignment.Dto.Employee;
import com.dev.pradeep.SunbaseAssignment.Services.CacheService;
import com.dev.pradeep.SunbaseAssignment.Services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Employees")
public class EmployeeController {

    private final CacheService cacheService;
    private final EmployeeService employeeService;

    public EmployeeController(CacheService cacheService, EmployeeService employeeService) {
        this.cacheService = cacheService;
        this.employeeService = employeeService;
    }

    @GetMapping("/CreateEmployee")
    public String createEmployee(){
        if(this.cacheService.isTokenAvailable()){
            return "add-employee";
        }
        return "redirect:/";
    }

    @PostMapping("/AddEmployee")
    public String addEmployee(Employee employee) {
        if (this.cacheService.isTokenAvailable()) {
            employee.uuid = employee.generateUUID();
            employeeService.addEmployee(employee);
            System.out.println("Successfully added employee");
            employeeService.fetchAllEmployees();
            return "redirect:/Employees";
        }
        return "redirect:/";
    }
}
