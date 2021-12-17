package com.hackaton.eHealth.controller;

import com.hackaton.eHealth.entities.Activity;
import com.hackaton.eHealth.entities.Food;
import com.hackaton.eHealth.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:3000/")
@RestController
public class FoodController {

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService=foodService;
    }

    @GetMapping("/list-food")
    public List<Food> getFood(){return foodService.getAllFoodFromUser();}

    //    @PostMapping("/add-food") - TODO

}
