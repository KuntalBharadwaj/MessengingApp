package com.bridglabz.greetingapp.service;

import com.bridglabz.greetingapp.model.Greeting;
import com.bridglabz.greetingapp.model.User;
import com.bridglabz.greetingapp.repository.GreetingRepository;
import com.bridglabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private GreetingRepository greetingRepository;

    public void setGreetingRepository(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Greeting addGreeting (User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World": user.toString());
        return greetingRepository.save(new Greeting (counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

}