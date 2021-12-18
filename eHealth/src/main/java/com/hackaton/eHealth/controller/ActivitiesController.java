package com.hackaton.eHealth.controller;

import com.hackaton.eHealth.entities.Activity;
import com.hackaton.eHealth.entities.DayDetails;
import com.hackaton.eHealth.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class ActivitiesController {

    private ActivitiesService activitiesService;

    @Autowired
    public ActivitiesController(ActivitiesService activitiesService){
        this.activitiesService = activitiesService;
    }

    @GetMapping("/list-activities")
    public List<Activity> getActivities(){return activitiesService.getAllActivitiesFromUser();}

//    @PostMapping("/add-activity") - TODO


}
