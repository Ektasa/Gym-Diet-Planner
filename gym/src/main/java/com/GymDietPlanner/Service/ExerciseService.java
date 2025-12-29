package com.GymDietPlanner.Service;

import com.GymDietPlanner.Entity.Exercise;
import com.GymDietPlanner.Entity.ExerciseCategory;
import com.GymDietPlanner.Repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    public Exercise create(Exercise e) { return exerciseRepository.save(e); }
    public List<Exercise> listAll() { return exerciseRepository.findAll(); }
    public List<Exercise> listByCategory(ExerciseCategory cat) { return exerciseRepository.findByCategory(cat); }
    public Exercise get(Long id) { return exerciseRepository.findById(id).orElse(null); }
}
