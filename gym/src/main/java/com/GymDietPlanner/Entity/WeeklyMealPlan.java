package com.GymDietPlanner.Entity;


import jakarta.persistence.*;


@Entity
@Table(name = "weekly_meal_plan")
public class WeeklyMealPlan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false, unique = true)
    private String day;


    private String breakfast;
    private Integer breakfastCal;


    private String lunch;
    private Integer lunchCal;


    private String dinner;
    private Integer dinnerCal;


    private Integer totalCal;


    // Constructors
    public WeeklyMealPlan() {}


    public WeeklyMealPlan(String day, String breakfast, Integer breakfastCal, String lunch, Integer lunchCal, String dinner, Integer dinnerCal, Integer totalCal) {
        this.day = day;
        this.breakfast = breakfast;
        this.breakfastCal = breakfastCal;
        this.lunch = lunch;
        this.lunchCal = lunchCal;
        this.dinner = dinner;
        this.dinnerCal = dinnerCal;
        this.totalCal = totalCal;
    }


// Getters and setters (omitted for brevity) — generate via IDE
}