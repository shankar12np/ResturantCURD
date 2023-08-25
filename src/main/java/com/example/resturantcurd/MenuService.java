package com.example.resturantcurd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;
    public void addMenuItems(Menu menu) {
        menuRepository.save(menu);
    }
}
