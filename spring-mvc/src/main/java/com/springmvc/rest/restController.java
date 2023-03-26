package com.springmvc.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
    @Value("${proj.name}")
    private String Name;

    @Value("${proj.age}")
    private int age;

    @GetMapping("/")
    public String hello(){
        return "hola mi amor";
    }

    @GetMapping("/name")
    public String getName(){
        return Name;
    }

    @GetMapping("/age")
    public int getAge(){
        return age+10;
    }

    @GetMapping("/home")
    public String hola(){
        return "manege banda magne";
    }
    @GetMapping("/mamaMia")
    public String mamaMia(){
        return "mama mia hola miaAmor";
    }

}
