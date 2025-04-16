package com.bridglabz.greetingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id
    private long Id;

    public Greeting(long l, String message) {

    }
}
