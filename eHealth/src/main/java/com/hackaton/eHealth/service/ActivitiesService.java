package com.hackaton.eHealth.service;

import com.hackaton.eHealth.entities.Activity;
import com.hackaton.eHealth.entities.DayDetails;
import com.hackaton.eHealth.repository.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitiesService {

    private ActivitiesRepository activitiesRepository;

    @Autowired
    public ActivitiesService (ActivitiesRepository activitiesRepository){
        this.activitiesRepository = activitiesRepository;
    }

    public List<Activity> getAllActivitiesFromUser(){
        return activitiesRepository.findAll();
    }

    //TODO: Add new activity to Activities

}
