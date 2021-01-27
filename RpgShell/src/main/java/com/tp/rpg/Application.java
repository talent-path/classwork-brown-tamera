package com.tp.rpg;

import com.tp.rpg.weapons.TypesOfWeapons;

import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        PlayerCharacter pc = setUpPlayer();






        while(pc.isAlive()){
            NonPlayerCharacter enemy = setUpEnemy();

           battle( pc, enemy );


        }

        gameOverScreen();

    }

    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {

        String name;
        TypesOfWeapons weapon;
        Scanner input= new Scanner(System.in);

        Console.print("Enter Name: ");
        name=input.nextLine();
        System.out.println(name);
        Console.print("Choose Weapon: ");
        weapon = TypesOfWeapons.valueOf(input.nextLine().toUpperCase());

            System.out.println(weapon);



       PlayerCharacter player= new PlayerCharacter(name,weapon,100);
        System.out.println(player);





        return player;
    }

    //create some NPC object (with armor & weapons?)
    private static NonPlayerCharacter setUpEnemy() {
        NonPlayerCharacter em=new Goblin("Goblin", TypesOfWeapons.ENERGYSWORD, 100);

        System.out.println(em);

        return em;
    }

    //a and b battle until one is dead
    private static void battle(Character a, Character b) {

        Character attacker = a;
        Character defender = b;


        while( a.isAlive() && b.isAlive() ){
            System.out.println(a.getName()+ "'s Turn");
            if(a.makeChoice().equals("Attack")){
                attacker.attack(b);
                DisplayHPstatus(a,b);
            }
            else if(a.makeChoice().equals("Block")) {
                attacker.block(b);
                DisplayHPstatus(a,b);
            }


            Character temp = a;
            a = b;
            b = temp;

            }



            //TODO: display HP status?

        }

    private static void DisplayHPstatus(Character a, Character b) {
        System.out.println(a.getName()+ "  " + a.getHealth());
        System.out.println(b.getName()+ "  " + b.getHealth());

    }


    //display some message
    private static void gameOverScreen() {
        System.out.println("Game Over........");
    }
}
