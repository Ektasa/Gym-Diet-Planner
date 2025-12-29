package com.GymDietPlanner.Service;


import com.GymDietPlanner.Entity.Plan;
import com.GymDietPlanner.Entity.PlanDuration;
import com.GymDietPlanner.Repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    public Plan create(Plan plan) { return planRepository.save(plan); }
    public List<Plan> listAll() { return planRepository.findAll(); }
    public Optional<Plan> get(Long id) { return planRepository.findById(id); }
    public Plan update(Plan plan) { return planRepository.save(plan); }
    public void delete(Long id) { planRepository.deleteById(id); }

    public Optional<Plan> getByDuration(PlanDuration duration) {
        return planRepository.findByDuration(duration);
    }
}
