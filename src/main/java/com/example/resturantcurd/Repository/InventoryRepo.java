package com.example.resturantcurd.Repository;

import com.example.resturantcurd.Entity.InventoryItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryItems, Long> {
}
