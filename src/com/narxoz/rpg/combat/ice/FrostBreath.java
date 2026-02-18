package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;

public class FrostBreath implements Ability {
    private String name;
    private int damage;
    private String description;

    public FrostBreath(String name) {
        this.name = name;
        this.damage = 40;
        this.description = "a cold attack that slows enemies";
    }
    /*  
    private FrostBreath(String name, int damage, String description) {
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
        return new FrostBreath(this.name);
    }
}
