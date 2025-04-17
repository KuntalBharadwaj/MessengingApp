package com.bridglabz.greetingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id
    private long Id;
    private String message;

    public Greeting() {
        this.message = "hello";
    }
    public Greeting(long l, String message) {
        this.Id = l;
        this.message = message;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
