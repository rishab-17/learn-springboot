package dev.rr.learn_spring.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {

    @GetMapping("/hello")
    String printHello(){
        return "This is hello";
    }

}
