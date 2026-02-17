package com.narxoz.rpg.combat;

public class FireShield implements Ability {
    @Override
    public String getName(){
        return "fire shield";
    }
    @Override 
    public int getDamage(){
        return 10; 
    }
    @Override
    public String getDescription(){
        return "creates a ring of fire around the user";
    }
    @Override 
    public Ability clone(){
        return new FireShield();
    }

    

    
}
