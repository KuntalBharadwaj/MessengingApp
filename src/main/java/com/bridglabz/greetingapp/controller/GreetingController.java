package com.bridglabz.greetingapp.controller;

import com.bridglabz.greetingapp.Hello;
import com.bridglabz.greetingapp.model.Greeting;
import com.bridglabz.greetingapp.model.User;
import com.bridglabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@RestController // controller and response body aggregation of RestController

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;

    @GetMapping(value = {"","/"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name,
                             @RequestParam(value = "last", defaultValue = "") String last) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/{id}")
    public Greeting getById(@PathVariable long id){
        return greetingService.getGreetingById(id);
    }
    @GetMapping("/allUsers")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/edit/{id}")
    public Greeting editGreeting(@PathVariable Long id,
                                 @RequestParam(value = "name", defaultValue = "") String name,
                                 @RequestParam(value = "last", defaultValue = "") String last) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.updateGreeting(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id){
        return greetingService.deleteGreeting(id);
    }
}
