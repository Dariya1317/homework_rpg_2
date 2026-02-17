package com.narxoz.rpg.combat;

public class Vanish implements Ability {
    @Override 
    public String getName() { 
        return "Vanish"; 
    }
    @Override 
    public int getDamage() { 
        return 0; 
    }
    @Override 
    public String getDescription() { 
        return "hide in the shadows to avoid attacks"; 
    }
    @Override 
    public Ability clone() { 
        return new Vanish(); 
    }
    }
    
