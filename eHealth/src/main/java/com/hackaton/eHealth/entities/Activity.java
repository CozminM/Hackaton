package com.hackaton.eHealth.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="activity")
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "caloriesAmount", nullable = false)
    private int caloriesAmount;

//    @Column(name = "minutes", nullable = false)
//    private int minutes;

    @Column(name = "activitySymbol", nullable = true)
    private String activitySymbolLink;
}
