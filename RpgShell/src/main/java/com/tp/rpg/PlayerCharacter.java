package com.tp.rpg;

import com.tp.rpg.weapons.TypesOfWeapons;

import java.util.Scanner;

public class PlayerCharacter {
    //use scanner here to get something from the user
    private String name;
    private TypesOfWeapons weapon;
    private  int Health;

    public PlayerCharacter(String name, TypesOfWeapons weapon, int Health) {
        super();
        this.name = name;
        this.weapon = weapon;
        this.Health=Health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypesOfWeapons getWeapon() {
        return weapon;
    }

    public void setWeapon(TypesOfWeapons weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                ", Health=" + Health +
                '}';
    }


    public String makeChoice() {

        throw new UnsupportedOperationException();
    }

}
