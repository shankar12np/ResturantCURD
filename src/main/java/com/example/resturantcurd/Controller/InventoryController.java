package com.example.resturantcurd.Controller;

import com.example.resturantcurd.Entity.InventoryItems;
import com.example.resturantcurd.Order;
import com.example.resturantcurd.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryItems>> getAllInventoryItems(){
        List<InventoryItems> items = inventoryService.getAllInventoryItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/inventory")
    public ResponseEntity<String> addItemToInventory(@RequestBody InventoryItems items){
        inventoryService.addItemToInventory(items);
        return ResponseEntity.ok("Item Added to in ventory");
    }

    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        boolean orderProcessed = inventoryService.processOrder(order);
        if (orderProcessed){
            return ResponseEntity.ok("Order placed successfully");
        }else {
            return ResponseEntity.badRequest().body("Order could not be processed. insufficient inventory");

        }
    }
}
