package com.example.resturantcurd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    public List<Menu> saveAll(List<Menu> menuToSave) {
        return menuRepository.saveAll(menuToSave);
    }

    public boolean updateMenuById(Long id, Menu upadtedMenu) {
        Optional<Menu> existingMenuOptional = menuRepository.findById(id);

        if (existingMenuOptional.isPresent()) {
            Menu existingMenu = existingMenuOptional.get();
            existingMenu.setSoup(upadtedMenu.getSoup());
            existingMenu.setAppetizer(upadtedMenu.getAppetizer());
            existingMenu.setSeafood(upadtedMenu.getSeafood());
            existingMenu.setPoultry(upadtedMenu.getPoultry());
            existingMenu.setMeat(upadtedMenu.getMeat());

            menuRepository.save(existingMenu);
            return true;
        } else {
            return false;
        }
    }

    public boolean partialUpdateMenu(Long id, Menu updatedMenu) {

        Optional<Menu> existingMenuOptional = menuRepository.findById(id);

      if(existingMenuOptional.isPresent()){
          Menu existingMenu = existingMenuOptional.get();

          //check and update individual fields only if they are provided in updatedMenu
          if (updatedMenu.getSoup() !=null){
              existingMenu.setSoup(updatedMenu.getSoup());
          }
          if (updatedMenu.getAppetizer() !=null){
              existingMenu.setAppetizer(updatedMenu.getAppetizer());
          }
          if (updatedMenu.getSeafood() !=null){
              existingMenu.setSeafood(updatedMenu.getSeafood());
          }
          if (updatedMenu.getPoultry() !=null){
              existingMenu.setPoultry(updatedMenu.getPoultry());
          }
          if (updatedMenu.getMeat() !=null){
              existingMenu.setMeat(updatedMenu.getMeat());
          }
            menuRepository.save(existingMenu);
            return true;
        } else {
            return false;
        }
    }

}