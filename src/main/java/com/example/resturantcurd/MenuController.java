package com.example.resturantcurd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping
    public ResponseEntity<String> addMenuIteams(@RequestBody Menu menu) {
        menuService.addMenuItems(menu);
        return ResponseEntity.ok("Menu Updated");
    }
    @GetMapping
    public ResponseEntity<List<Menu>> getMenu() {
        List<Menu> allMenus = menuService.getAllMenus();
        return ResponseEntity.ok(allMenus);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenuById(@PathVariable Long id) {
        menuService.deleteById(id);
        return ResponseEntity.ok("Menu Items Deleted");
    }
}
