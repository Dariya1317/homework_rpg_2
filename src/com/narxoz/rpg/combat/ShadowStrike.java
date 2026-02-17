package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {
    @Override 
    public String getName() { 
        return "Shadow Strike"; 
    }
    @Override 
    public int getDamage() { 
        return 70; 
    }
    @Override 
    public String getDescription() { 
        return "a sudden attack from the dark"; 
    }
    @Override 
    public Ability clone() { 
        return new ShadowStrike();
    }
    
}
