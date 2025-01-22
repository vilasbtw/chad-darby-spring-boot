package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {

    private Coach coach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach coach,
                          @Qualifier("trackCoach") Coach anotherCoach) {
        this.coach = coach;
        this.anotherCoach = anotherCoach;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("check")
    public String checkCoaches() {
        return "Same beans? " + (coach == anotherCoach);
    }

}