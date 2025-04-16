package com.bridglabz.greetingapp.service;

import com.bridglabz.greetingapp.model.Greeting;
import com.bridglabz.greetingapp.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
}
