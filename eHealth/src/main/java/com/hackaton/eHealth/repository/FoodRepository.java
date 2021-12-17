package com.hackaton.eHealth.repository;
import com.hackaton.eHealth.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
}
