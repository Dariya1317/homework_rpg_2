package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;

public class IceShield implements Ability {
    private String name;
    private int damage;
    private String description;

    public IceShield(String name) {
        this.name = name;
        this.damage = 5;
        this.description = "a strong wall of ice for protection";
    }
    /*  
    private IceShield(String name, int damage, String description) {
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
        return new IceShield(this.name);
    }
}
