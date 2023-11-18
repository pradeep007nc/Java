package com.dev.pradeep.SunbaseAssignment.Controller;

import com.dev.pradeep.SunbaseAssignment.Dto.Employee;
import com.dev.pradeep.SunbaseAssignment.Dto.LoginDto;
import com.dev.pradeep.SunbaseAssignment.Services.CacheService;
import com.dev.pradeep.SunbaseAssignment.Services.EmployeeService;
import com.dev.pradeep.SunbaseAssignment.Services.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class LoginController {

    private final LoginService loginService;
    private final CacheService cacheService;
    private final EmployeeService employeeService;

    public LoginController(LoginService loginService, CacheService cacheService, EmployeeService employeeService){
        this.loginService = loginService;
        this.cacheService = cacheService;
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String loginPage(){
        return "login-page";
    }


    @PostMapping("/login")
    public String loginSubmit(LoginDto loginDto) {

        System.out.println("Username: " + loginDto.getLoginId());
        System.out.println("Password: " + loginDto.getPassword());

        //now call service
        //if not token doesn't exist
        String token = loginService.getAccessToken(loginDto);
        if (token == null || token.split(":")[0].equals("Error")) {
            return "redirect:/";
        }

        // else cache data and redirect
        cacheService.addToken(loginDto.getLoginId(), token);
        employeeService.fetchAllEmployees();
        // Redirect to a success page or handle login logic as needed
        return "redirect:/Employees";

    }

    @GetMapping("/Employees")
    public String showEmployeesPage(Model model) {
        // Add your logic here
        if (this.cacheService.isTokenAvailable()) {
            employeeService.fetchAllEmployees();
            model.addAttribute("employees", employeeService.getEmployees());
            return "employees-page";
        }
        return "redirect:/";
    }

}
