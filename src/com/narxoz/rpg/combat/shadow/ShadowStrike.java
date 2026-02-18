package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;

public class ShadowStrike implements Ability {
    private String name;
    private int damage;
    private String description;

    public ShadowStrike(String name) {
        this.name = name;
        this.damage = 70;
        this.description = "a sudden attack from the dark";
    }
    /*  
    private ShadowStrike(String name, int damage, String description) {
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
        return new ShadowStrike(this.name);
    }
    
}
