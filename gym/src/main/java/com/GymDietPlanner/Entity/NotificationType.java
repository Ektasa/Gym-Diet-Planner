package com.GymDietPlanner.Entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

public enum NotificationType {
    DAILY_REMINDER,
    EXERCISE_REMINDER,
    PLAN_BASED
}