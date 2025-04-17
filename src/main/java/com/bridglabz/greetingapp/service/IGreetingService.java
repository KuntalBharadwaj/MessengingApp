package com.bridglabz.greetingapp.service;

import com.bridglabz.greetingapp.model.Greeting;
import com.bridglabz.greetingapp.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
    List<Greeting> getAllGreetings();
    Greeting updateGreeting(Long id, User user);
    String deleteGreeting(Long id);
}
