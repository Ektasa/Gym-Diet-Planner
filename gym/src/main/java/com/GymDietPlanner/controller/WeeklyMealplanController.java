package com.GymDietPlanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class WeeklyMealplanController {

    @GetMapping("/get")
    public String getMealPlan() {
        return "This is your weekly meal plan.";
    }
    @GetMapping("/getmal4patle")
    private Map<String, String> getPatlePlan() {
        Map<String, String> plan = new LinkedHashMap<>();
        plan.put("Monday", "Full-fat milk, peanut butter sandwich, bananas");
        plan.put("Tuesday", "Avocado toast, eggs, smoothie with nut butter");
        plan.put("Wednesday", "Pasta with cheese and chicken");
        plan.put("Thursday", "Rice, lentils, paneer or tofu");
        plan.put("Friday", "Granola with yogurt, dried fruits");
        plan.put("Saturday", "Peanut butter smoothie, nuts");
        plan.put("Sunday", "Whole milk, potatoes, protein-rich meal");
        return plan;
    }
}
