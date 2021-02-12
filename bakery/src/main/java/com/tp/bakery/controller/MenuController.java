package com.tp.bakery.controller;

import com.tp.bakery.model.Menu;
import com.tp.bakery.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class MenuController {

    @Autowired
    MenuService service;

    @GetMapping("/menus")
    List<Menu> getAllMenus(){
        return service.getAllMenus();
    }
    @PostMapping("/addMenu")
    public ResponseEntity addMenu(Menu newMenu){
        Menu menu= service.addMenu(newMenu);
        return ResponseEntity.ok(menu);
    }
}
