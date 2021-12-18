package com.hackaton.eHealth.service;

import com.hackaton.eHealth.entities.DayDetails;
import com.hackaton.eHealth.repository.DayDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayDetailsService {

    private DayDetailsRepository dayDetailsRepository;

    @Autowired
    public DayDetailsService(DayDetailsRepository dayDetailsRepository){
        this.dayDetailsRepository=dayDetailsRepository;
    }

    public List<DayDetails> getAllDetailsFromUser(){
        return dayDetailsRepository.findAll();
    }

    public void addDetails(DayDetails dayDetails){
        dayDetailsRepository.save(dayDetails);
    }


}
