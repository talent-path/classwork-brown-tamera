package com.tp.rpg;

import com.tp.rpg.weapons.TypesOfWeapons;

public class Goblin extends NonPlayerCharacter{

    public Goblin(String name, TypesOfWeapons weapon, int Health) {
        super(name, weapon, Health);
    }
    @Override
    public String makeChoice(){
        return "attack";
    }
}
