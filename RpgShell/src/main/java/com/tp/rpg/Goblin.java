package com.tp.rpg;

import com.tp.rpg.weapons.TypesOfWeapons;

import java.util.Scanner;

public class Goblin extends NonPlayerCharacter{

    public Goblin(String name, TypesOfWeapons weapon, int Health) {
        super(name, weapon, Health);
    }

    @Override
    public String makeChoice(){
        Scanner input=new Scanner(System.in);
        String option;
        Console.print("Choose an action");
        option=input.nextLine();

        return option;
    }
}
