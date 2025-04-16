package com.bridglabz.greetingapp.controller;

import com.bridglabz.greetingapp.Hello;
import com.bridglabz.greetingapp.model.Greeting;
import com.bridglabz.greetingapp.model.User;
import com.bridglabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController // controller and response body aggregation of RestController
@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private IGreetingService greetingService;



    @GetMapping("")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
}
