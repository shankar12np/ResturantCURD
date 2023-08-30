package com.example.resturantcurd.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long itemId;
    Integer quantity;

@ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
