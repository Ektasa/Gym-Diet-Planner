package com.GymDietPlanner.controller;

import com.GymDietPlanner.Entity.WeeklyMealPlan;
import com.GymDietPlanner.Repository.WeeklyMealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WeeklyMealplanController {

    @Autowired
    private WeeklyMealPlanRepository weeklyMealPlanRepository;

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

    // New endpoint to get all weekly meal plans
    @GetMapping("/patle")
    public ResponseEntity<List<WeeklyMealPlan>> getAllWeeklyMealPlans() {
        try {
            List<WeeklyMealPlan> mealPlans = weeklyMealPlanRepository.findAll();
            return ResponseEntity.ok(mealPlans);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
