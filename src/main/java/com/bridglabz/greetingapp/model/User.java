package com.bridglabz.greetingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class User {
    @Id
    private String FirstName;
    private ArrayList<Greeting> greetings;

    public ArrayList<Greeting> getGreetings() {
        return greetings;
    }

    public void setGreetings(ArrayList<Greeting> greetings) {
        this.greetings = greetings;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

}
