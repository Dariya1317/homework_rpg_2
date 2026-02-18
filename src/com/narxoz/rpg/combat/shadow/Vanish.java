package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;

public class Vanish implements Ability {
    private String name;
    private int damage;
    private String description;

    public Vanish(String name) {
        this.name = name;
        this.damage = 0;
        this.description = "hide in the shadows to avoid attacks";
    }
    /*  
    private Vanish(String name, int damage, String description) {
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
        return new Vanish(this.name);
    }
}
    
