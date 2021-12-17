package com.hackaton.eHealth.repository;

import com.hackaton.eHealth.entities.DayDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayDetailsRepository extends JpaRepository<DayDetails,Long> {

    // alternativa la SQL

}
