package com.tp.bakery.controller;

import com.tp.bakery.model.Dessert;
import com.tp.bakery.service.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BakeryController {

    @Autowired
    BakeryService service;

@GetMapping("/desserts")
    public List<Dessert> getAllDesserts(){
        return service.getAllDesserts();
    }

    @GetMapping("/dessert/{dessertId}")
    public ResponseEntity getDessertById(@PathVariable Integer dessertId) {
        Dessert retrievedDessert = service.getDessertById(dessertId);
        return ResponseEntity.ok(retrievedDessert);
    }


    @PostMapping("/addDessert")
    public ResponseEntity addDessert(@RequestBody Dessert dessert){

       Dessert newDessert=service.addDessert(dessert);
       return ResponseEntity.ok(newDessert);
    }
    @PutMapping("/editDessert/{dessertId}")
    public int editDessert(@PathVariable Integer dessertId, @RequestBody Dessert dessert){
       return service.editDessert(dessertId,dessert);

    }
    @DeleteMapping("/deleteDessert/{dessertId}")
    public ResponseEntity deleteDessert(@PathVariable Integer dessertId){
    Dessert deleted=service.deleteDessert(dessertId);
    return ResponseEntity.ok(deleted);
    }




}