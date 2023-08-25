package com.example.resturantcurd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;



@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
