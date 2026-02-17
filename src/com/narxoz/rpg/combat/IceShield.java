package com.narxoz.rpg.combat;

public class IceShield implements Ability {
    @Override
    public String getName(){
        return "ice shield";
    }
    @Override
    public int getDamage(){
        return 5;
    }
    @Override
    public String getDescription(){
        return "a strong wall of ice for protection";
    }
    @Override
    public Ability clone(){
        return new IceShield();
    }
}
