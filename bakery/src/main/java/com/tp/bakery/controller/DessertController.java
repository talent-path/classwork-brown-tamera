package com.tp.bakery.controller;

import com.tp.bakery.execptions.*;
import com.tp.bakery.model.Dessert;
import com.tp.bakery.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DessertController {

    @Autowired
    DessertService service;

@GetMapping("/desserts")
    public List<Dessert> getAllDesserts(){
        return service.getAllDesserts();
    }

    @GetMapping("/dessert/{dessertId}")
    public ResponseEntity getDessertById(@PathVariable Integer dessertId) throws NullDessertIdException, InvaildDessertIdException {
        Dessert retrievedDessert = service.getDessertById(dessertId);
        return ResponseEntity.ok(retrievedDessert);
    }


    @PostMapping("/addDessert")
    public ResponseEntity addDessert(@RequestBody Dessert dessert) throws NullDessertObjectException, NulllDessertNameException, NullDessertDescriptionException {

       Dessert newDessert=service.addDessert(dessert);
       return ResponseEntity.ok(newDessert);
    }
    @PutMapping("/editDessert/{dessertId}")
    public int editDessert(@PathVariable Integer dessertId, @RequestBody Dessert dessert) throws NullDessertIdException, NullDessertObjectException, NulllDessertNameException, NullDessertDescriptionException{
       return service.editDessert(dessertId,dessert);

    }
    @DeleteMapping("/deleteDessert/{dessertId}")
    public int deleteDessert(@PathVariable Integer dessertId) throws NullDessertIdException {
    return service.deleteDessert(dessertId);

    }
    @PutMapping("/add/{menuId}/{dessertId}")
    public void addDessertToMenu(@PathVariable Integer menuId, @PathVariable Integer dessertId){
     service.addDessertToMenu();
    }





}
