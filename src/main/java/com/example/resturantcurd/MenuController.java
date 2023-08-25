package com.example.resturantcurd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping
    public ResponseEntity<String>addMenuIteams(@RequestBody Menu menu){
        menuService.addMenuItems(menu);
        return ResponseEntity.ok("Menu Updated");
    }



}
