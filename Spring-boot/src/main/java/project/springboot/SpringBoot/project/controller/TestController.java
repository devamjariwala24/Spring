package project.springboot.SpringBoot.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {


//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String testController() {
        return "Welcome to the controller package!!! ah this is not working not entering in a new line";
    }
}
