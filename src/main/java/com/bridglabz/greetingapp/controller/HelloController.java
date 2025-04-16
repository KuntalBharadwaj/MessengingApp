package com.bridglabz.greetingapp.controller;



import com.bridglabz.greetingapp.model.UserInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello") // integrate all http methods
public class HelloController {
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello !";
    }

//    @RequestMapping(value = {"/query"} ,method = RequestMethod.GET)
//    public String sayHello(@RequestParam(required = false, defaultValue = "Guest") String name) {
//        return "Hello "+name+ "!";
//    }

    @GetMapping("/param/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello "+name+ "!";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody UserInfo user) {
        return "Hello "+ user.getFirstname() + "!";
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,
                           @RequestParam(value = "lastname")String lastname) {
        return "Hello "+ firstName + " " + lastname + "!";
    }
}