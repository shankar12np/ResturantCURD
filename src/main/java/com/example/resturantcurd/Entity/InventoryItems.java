package com.example.resturantcurd.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Inventory")
public class InventoryItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String sku;
    String name;
   Integer count;
    String price;

}
