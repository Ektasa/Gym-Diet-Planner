package com.GymDietPlanner.Repository;


import com.GymDietPlanner.Entity.BodyType;
import com.GymDietPlanner.Entity.DietChart;
import com.GymDietPlanner.Entity.MealType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DietChartRepository extends JpaRepository<DietChart, Long> {
    List<DietChart> findByBodyType(BodyType bodyType);
    Optional<DietChart> findByBodyTypeAndMealType(BodyType bodyType, MealType mealType);
}