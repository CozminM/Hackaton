package com.hackaton.eHealth.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayDetails {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name="intake", nullable = false)
    private int intakeCalories;

    @Column(name="consumed", nullable = false)
    private int consumedCalories;

//    @OneToMany(targetEntity = Activity.class)
//    private List<Activity> userActivities;
//
//    @OneToMany(targetEntity = Food.class)
//    private List<Food> userFoodList;

}
