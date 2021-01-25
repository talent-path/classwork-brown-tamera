package com.tp.rpg;

import com.tp.rpg.weapons.TypesOfWeapons;

public abstract class NonPlayerCharacter extends Character {


    public NonPlayerCharacter(String name, TypesOfWeapons weapon, int Health) {
        super(name, weapon, Health);
    }


}
