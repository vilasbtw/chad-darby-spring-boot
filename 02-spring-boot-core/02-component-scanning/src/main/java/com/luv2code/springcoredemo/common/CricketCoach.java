package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

// Marks this class as a Spring Bean and makes it available to D.I
@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}