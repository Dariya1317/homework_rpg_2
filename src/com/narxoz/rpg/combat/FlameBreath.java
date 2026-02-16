package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {
    @Override 
    public String getName(){
        return "flame breath";
    
    }
    @Override
    public int getDamage(){
        return 50;

    } 
    public String getDescription(){
        return "Used to hit heroes with a wave of fire";
    }
    @Override 
    public Ability clone(){
        return new FlameBreath();

    }

    
}
