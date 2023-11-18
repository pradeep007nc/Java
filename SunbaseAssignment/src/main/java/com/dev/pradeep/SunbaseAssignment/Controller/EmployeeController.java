package com.dev.pradeep.SunbaseAssignment.Controller;

import com.dev.pradeep.SunbaseAssignment.Dto.Employee;
import com.dev.pradeep.SunbaseAssignment.Services.CacheService;
import com.dev.pradeep.SunbaseAssignment.Services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    public String createEmployee(Model model){
        if(this.cacheService.isTokenAvailable()){
            model.addAttribute("employee", new Employee());
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

    @GetMapping("/UpdateEmployee/{uuid}")
    public String showEmployeeToBeUpdated(Model model, @PathVariable("uuid") String uuid) {
        if (this.cacheService.isTokenAvailable()) {
            Employee employee = employeeService.getEmployeeById(uuid);
            // Retrieve the employee by UUID and add it to the model
            model.addAttribute("employee", employee);
            return "update-employee";
        }
        return "redirect:/";
    }


    @PostMapping("/UpdateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        if (this.cacheService.isTokenAvailable()) {
            System.out.println(employee.toString()+" working");
            String uuid = employee.getUuid();
            employeeService.updateEmployee(uuid, employee);
            System.out.println("Successfully updated employee");
            return "redirect:/Employees";
        }
        return "redirect:/";
    }

    @PostMapping("/DeleteEmployee/{uuid}")
    public String deleteEmployee(@PathVariable("uuid") String uuid) {
        if (this.cacheService.isTokenAvailable()) {
            employeeService.deleteEmployee(uuid);
            employeeService.fetchAllEmployees();
            return "redirect:/Employees";
        }
        return "redirect:/";
    }

    @GetMapping("/DeleteAllEmployees")
    public String deleteAllEmployees(){
        if (this.cacheService.isTokenAvailable()){
            employeeService.deleteAllEmployees();
            return "redirect:/Employees";
        }
        return "redirect:/";
    }

}
