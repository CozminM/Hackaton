package com.hackaton.eHealth.service;

import com.hackaton.eHealth.entities.Food;
import com.hackaton.eHealth.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodService (FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFoodFromUser(){
        return foodRepository.findAll();
    }

    ////TODO: Add new food to Food
}
