package com.hackaton.eHealth.repository;
import com.hackaton.eHealth.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivitiesRepository extends JpaRepository<Activity,Long> {
}
