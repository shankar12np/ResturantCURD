package com.example.resturantcurd.Service;

import com.example.resturantcurd.Entity.InventoryItems;
import com.example.resturantcurd.Order;
import com.example.resturantcurd.OrderItem;
import com.example.resturantcurd.Repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    public List<InventoryItems> getAllInventoryItems() {
        return inventoryRepo.findAll();
    }

    public void addItemToInventory(InventoryItems items) {
        inventoryRepo.save(items);
    }

    public boolean processOrder(Order order) {
        for (OrderItem orderItem : order.getItems()) {
            InventoryItems inventoryItem = inventoryRepo.findById(orderItem.getItemId()).orElse(null);

            if (inventoryItem != null && inventoryItem.getCount() >= orderItem.getQuantity()) {
                inventoryItem.setCount(inventoryItem.getCount() - orderItem.getQuantity());
                inventoryRepo.save(inventoryItem);
            } else {
                return false; // Not enough inventory for this order item
            }
        }
        return true; // Order processed successfully
    }


}
