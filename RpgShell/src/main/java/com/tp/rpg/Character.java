package com.tp.rpg;

import com.tp.rpg.weapons.TypesOfWeapons;
import com.tp.rpg.weapons.Weapon;

//TODO:
//      add a concept of hitpoints
//      add a concept of armor (or maybe multiple pieces of armor)
//      add a concept of a weapon (or maybe multiple weapons)
//Stretch goals:
//      add a potion class/interface that the character can drink instead of attacking
//      let the character "disarm" the opponent instead of attacking
//          base this on the weapons used?
//      let the character choose to "block" or "defend"
//          could stun the opponent if they attack?
//          could give us TWO attacks on the next round?
public abstract class Character implements Chooser, Weapon {
    private String name;
    private TypesOfWeapons weapon;
    private  int Health;

    public Character(String name, TypesOfWeapons weapon, int Health) {

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
        return "Character{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                ", Health=" + Health +
                '}';
    }


    //TODO: add fields for armor(s) and weapon(s)

    public void attack( Character defender ){

        defender.setHealth(defender.getHealth()-defender.getWeapon().value);


    }
    public void block(Character attacker){throw  new UnsupportedOperationException();}

    public void takeDamage( int damage ){
        throw new UnsupportedOperationException();
    }

    public boolean isAlive(){;

        int currentHealth=getHealth();
        if(currentHealth!=0) return true;
        else return false;
    }

}
