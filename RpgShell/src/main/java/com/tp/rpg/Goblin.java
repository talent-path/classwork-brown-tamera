package com.tp.rpg;

import com.tp.rpg.weapons.TypesOfWeapons;

//goblins always attack?
public class Goblin extends NonPlayerCharacter {
    private String name;
    TypesOfWeapons weapon;
    private int Health;

    public Goblin(String name, TypesOfWeapons weapon, int Health) {
        super(name,weapon,Health);
//        this.name = name;
//        this.weapon = weapon;
//        this.Health=Health;
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
        return "Goblin{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                ", Health=" + Health +
                '}';
    }

    @Override
    public String makeChoice() {
        return "attack";
    }
}
