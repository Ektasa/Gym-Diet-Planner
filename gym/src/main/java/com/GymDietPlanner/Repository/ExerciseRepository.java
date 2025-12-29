package com.GymDietPlanner.Repository;

import com.GymDietPlanner.Entity.Exercise;
import com.GymDietPlanner.Entity.ExerciseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByCategory(ExerciseCategory category);
}
