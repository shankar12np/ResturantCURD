package com.example.resturantcurd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;
    public void addMenuItems(Menu menu) {
        menuRepository.save(menu);
    }

      public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public ResponseEntity<String> deleteMenuById(@PathVariable Long id) {
         menuRepository.deleteById(id);
         return ResponseEntity.ok("Menu Items Deleted");
    }

    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }

//    public List<Menu> saveAll(Menu menu) {
//        return menuRepository.saveAll();
//    }
}