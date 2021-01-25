package com.tp.rpg.weapons;

import com.tp.rpg.Rng;

public enum TypesOfWeapons {

    GRAVITYGUN(Rng.randInt(0,11)),
    ENERGYSWORD(Rng.randInt(0,11));



    public int value = -1;

    TypesOfWeapons( int value ){
        this.value = value;
    }
}
