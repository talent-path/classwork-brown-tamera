package com.tp.diceroller.controller;

import com.tp.diceroller.service.Rng;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {

    @GetMapping("/helloworld")
    public String HelloWorld(){
        return "Hello World";
    }
    @GetMapping("/sixsides")
    public int sixSides(){
       return Rng.RollDice(6);
    }
    @GetMapping("/Twentysides")
    public int twentySide(){
        return Rng.RollDice(20);
    }
    @GetMapping("/nsides")
    public int NSides(Integer num){
        return Rng.RollDice(num);
    }
    @GetMapping("/nsides/{num}")
   public int NsizePathVariable(@PathVariable Integer num){
        return Rng.RollDice(num);
    }
}
