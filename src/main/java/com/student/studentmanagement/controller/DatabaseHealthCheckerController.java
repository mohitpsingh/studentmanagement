package com.student.studentmanagement.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseHealthCheckerController implements HealthIndicator {

    public static final String DB_HEALTH = "Database Health";
    public boolean isHealthUp() {
        return true;
    }
    @Override
    public Health health() {
        if (isHealthUp()) {
            return Health.up().withDetail(DB_HEALTH, "Database Service is Running Up").build();
        }
        return Health.down().withDetail(DB_HEALTH, "Database Service is Running Down").build();
    }
}
