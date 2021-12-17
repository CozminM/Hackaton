package com.hackaton.eHealth.controller;

import com.hackaton.eHealth.entities.DayDetails;
import com.hackaton.eHealth.repository.DayDetailsRepository;
import com.hackaton.eHealth.service.DayDetailsService;
import com.hackaton.eHealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class DayController {

    private DayDetailsService dayDetailsService;

    @Autowired
    public DayController(DayDetailsService dayDetailsService){
        this.dayDetailsService = dayDetailsService;
    }

    @GetMapping("/list-details")
    public List<DayDetails> getDetails(){return dayDetailsService.getAllDetailsFromUser();}

    @PostMapping("/add-details")
    public void addDetailsToUser(){};

}
