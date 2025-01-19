package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello, world!";
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "Do 100 push ups";
    }

    @GetMapping("/message")
    public String getMessage() {
        return "I am a machine.";
    }
}
