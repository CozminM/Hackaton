package com.hackaton.eHealth.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="food")
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "caloriesAmount", nullable = false)
    private int caloriesAmount;

//    @Column(name = "grams", nullable = false)
//    private int grams;

    @Column(name = "foodSymbol", nullable = false)
    private String foodSymbolLink;

}
