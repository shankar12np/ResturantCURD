package com.example.resturantcurd.Entity;

import com.example.resturantcurd.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;
    private String soup;
    private String appetizer;
    private String seafood;
    private String poultry;
    private String meat;

//    private Integer soupCount;
//    private Integer appetizerCount;
//    private Integer seafoodCount;
//    private Integer meatCount;



}