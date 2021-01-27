package com.tp.rpg;

import com.tp.rpg.weapons.TypesOfWeapons;

import java.util.Scanner;

public class PlayerCharacter extends Character {

    public PlayerCharacter(String name, TypesOfWeapons weapon, int Health) {
        super(name, weapon, Health);
    }
    //use scanner here to get something from the user

@Override
    public String makeChoice() {
        Scanner input=new Scanner(System.in);
        String option;
        Console.print("Choose an action");
        option=input.nextLine();

       return option;
    }

    public int generateDamage() {
        return 0;
    }

}
