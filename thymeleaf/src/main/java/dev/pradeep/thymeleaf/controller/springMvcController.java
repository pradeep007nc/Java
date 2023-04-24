package dev.pradeep.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class springMvcController {

    //create a mapping for hello
    @GetMapping("/date")
    public String hello(Model model){
        model.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }
}
