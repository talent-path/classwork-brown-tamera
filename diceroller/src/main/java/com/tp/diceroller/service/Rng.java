package com.tp.diceroller.service;

import java.util.Random;

public class Rng {
    static Random rng=new Random();

    public static int RollDice(int size){
       return rng.nextInt(size)+1;

    }

}
