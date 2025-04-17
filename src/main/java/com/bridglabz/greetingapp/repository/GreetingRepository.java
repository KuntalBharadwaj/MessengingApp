package com.bridglabz.greetingapp.repository;

import com.bridglabz.greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}
