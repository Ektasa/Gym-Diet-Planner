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

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public Integer getBreakfastCal() {
        return breakfastCal;
    }

    public void setBreakfastCal(Integer breakfastCal) {
        this.breakfastCal = breakfastCal;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public Integer getLunchCal() {
        return lunchCal;
    }

    public void setLunchCal(Integer lunchCal) {
        this.lunchCal = lunchCal;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public Integer getDinnerCal() {
        return dinnerCal;
    }

    public void setDinnerCal(Integer dinnerCal) {
        this.dinnerCal = dinnerCal;
    }

    public Integer getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(Integer totalCal) {
        this.totalCal = totalCal;
    }
}