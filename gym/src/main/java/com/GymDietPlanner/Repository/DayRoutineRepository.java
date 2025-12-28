package com.GymDietPlanner.Repository;

import com.GymDietPlanner.Entity.BodyType;
import com.GymDietPlanner.Entity.DayOfWeek;
import com.GymDietPlanner.Entity.DayRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DayRoutineRepository extends JpaRepository<DayRoutine, Long> {
    Optional<DayRoutine> findByDayAndBodyType(DayOfWeek day, BodyType bodyType);
    List<DayRoutine> findByBodyType(BodyType bodyType);
    List<DayRoutine> findByDay(DayOfWeek day);
}

