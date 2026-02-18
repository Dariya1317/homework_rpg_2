package com.narxoz.rpg.combat.fire;

import com.narxoz.rpg.combat.Ability;

public class FireShield implements Ability {
    private String name;
    private int damage;
    private String description;

    public FireShield(String name) {
        this.name = name;
        this.damage = 10;
        this.description = "creates a ring of fire around the user";
    }
    /*  
    private FireShield(String name, int damage, String description) {
        this.name = name;
        this.damage = damage;
        this.description = description;
    */

    @Override 
    public String getName(){
        return name;
    }

    @Override
    public int getDamage(){
        return damage;
    } 

    @Override
    public String getDescription(){
        return description;
    }

    @Override 
    public Ability clone(){
        return new FireShield(this.name);
    }
  

    
}
