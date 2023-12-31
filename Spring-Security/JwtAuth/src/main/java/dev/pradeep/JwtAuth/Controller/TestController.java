package dev.pradeep.JwtAuth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/dummy")
    public List<?> dummyTest(){
        return List.of("demo", 1, "pradeep");
    }

}
