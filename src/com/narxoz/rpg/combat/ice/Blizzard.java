package com.narxoz.rpg.combat.ice;

import com.narxoz.rpg.combat.Ability;

public class Blizzard implements Ability {
    private String name;
    private int damage;
    private String description;

    public Blizzard(String name) {
        this.name = name;
        this.damage = 80;
        this.description = "a massive snowstorm that freezes everything";
    }

    @Override public String getName() { 
        return name;
    }
    @Override public int getDamage() {
        
        return damage; 
    }
    @Override public String getDescription() {
         return description; 
    }
    @Override 
    public Ability clone() {
        return new Blizzard(this.name);
    }
    
}
