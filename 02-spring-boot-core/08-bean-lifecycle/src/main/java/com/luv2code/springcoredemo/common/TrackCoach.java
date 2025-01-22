package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In construction: " + getClass().getSimpleName());
    }

    // Method used when initializing beans lifecycle
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyDestroyStuff(): " + getClass().getSimpleName());
    }

    // Method used before destroying beans lifecycle
    @PreDestroy
    public void doMyDestroyStuff() {
        System.out.println("In doMyDestroyStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}