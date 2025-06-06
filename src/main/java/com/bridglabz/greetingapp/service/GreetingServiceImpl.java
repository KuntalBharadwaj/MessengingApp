package com.bridglabz.greetingapp.service;

import com.bridglabz.greetingapp.model.Greeting;
import com.bridglabz.greetingapp.model.User;
import com.bridglabz.greetingapp.repository.GreetingRepository;
import com.bridglabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private GreetingRepository greetingRepository;

    @Autowired
    public GreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Greeting addGreeting (User user) {

        String message;
        if (!user.getFirstName().isEmpty()) {
            message = String.format(template, user.getFirstName());
        } else {
            message = String.format(template, "Hello World");
        }
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
}



    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting updateGreeting(Long id, User user) {
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));

        String message;
        if (!user.getFirstName().isEmpty()) {
            message = String.format(template, user.getFirstName());
        } else {
            message = String.format(template, "Hello World");
        }

        existingGreeting.setMessage(message);
        return greetingRepository.save(existingGreeting);
    }

    @Override
    public String deleteGreeting(Long id){
        greetingRepository.delete(getGreetingById(id));
        return "successfully deleted";
    }


}