package com.GymDietPlanner.Repository;

import com.GymDietPlanner.Entity.WeeklyMealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WeeklyMealPlanRepository extends JpaRepository<WeeklyMealPlan, Integer> {
    Integer id(Integer id);
    List<WeeklyMealPlan> findAll();
//    WeeklyMealPlan findByDayAndMonth(String day, String month);

}