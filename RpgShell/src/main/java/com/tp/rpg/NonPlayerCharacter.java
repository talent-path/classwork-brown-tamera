package com.tp.rpg;

import com.tp.rpg.weapons.TypesOfWeapons;

import java.util.Scanner;

public abstract class NonPlayerCharacter extends Character {


    public NonPlayerCharacter(String name, TypesOfWeapons weapon, int Health) {
        super(name, weapon, Health);
    }





    public int generateDamage() {
        return 0;
    }
}
