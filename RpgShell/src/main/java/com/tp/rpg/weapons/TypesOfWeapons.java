package com.tp.rpg.weapons;

import com.tp.rpg.Rng;

public enum TypesOfWeapons {

    GRAVITYGUN(Rng.randInt(10,20)),
    ENERGYSWORD(Rng.randInt(10,20));



    public int value = -1;

    TypesOfWeapons( int value ){
        this.value = value;
    }
}
