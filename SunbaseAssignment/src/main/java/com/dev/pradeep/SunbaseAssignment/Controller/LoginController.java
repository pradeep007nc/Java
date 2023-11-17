package com.dev.pradeep.SunbaseAssignment.Controller;

import com.dev.pradeep.SunbaseAssignment.Dto.LoginDto;
import com.dev.pradeep.SunbaseAssignment.Services.CacheService;
import com.dev.pradeep.SunbaseAssignment.Services.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class LoginController {

    private final LoginService loginService;
    private final CacheService cacheService;

    public LoginController(LoginService loginService, CacheService cacheService){
        this.loginService = loginService;
        this.cacheService = cacheService;
    }

    @GetMapping("/")
    public String loginPage(){
        return "login-page";
    }

    @GetMapping("/Employees")
    public String showEmployeesPage(Model model) {
        // Create a LoginDto object and add it to the model
        LoginDto loginDto = new LoginDto();
        model.addAttribute("data", loginDto);

        return "employees-page";
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
        // Redirect to a success page or handle login logic as needed
        return "redirect:/Employees";

    }



}
