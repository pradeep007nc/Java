package dev.pradeep.jwtauthentication.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<String > sayHello(){
        return ResponseEntity.ok("hello  from secured");
    }

}
