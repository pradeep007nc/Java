package dev.pradeep.oAuth.oAuth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class HomeController {

    @GetMapping("/")
    public List home(){
        return Stream.of("mama", 1, "mia", 12, "mor").collect(Collectors.toList());
    }

    @GetMapping("/secured")
    public List secured(){
        return Stream.of("le donga", 420, "nan magane", "henge bangde illi").collect(Collectors.toList());
    }
}
