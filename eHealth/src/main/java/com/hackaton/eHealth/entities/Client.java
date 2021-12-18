//package com.hackaton.eHealth.entities;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "clients")
//@NoArgsConstructor
//@AllArgsConstructor
//public class Client {
//
//    @Id
//    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "password", nullable = false)
//    private String password;
//
//    @Column(name = "mail", nullable = false)
//    private String mail;
//
//    @OneToMany(targetEntity = DayDetails.class)
//    private List<DayDetails> dayDetails;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    private List<String> roles = new ArrayList<>();
//
//}
