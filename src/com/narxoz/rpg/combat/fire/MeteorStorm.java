package com.narxoz.rpg.combat.fire;

import com.narxoz.rpg.combat.Ability;

public class MeteorStorm implements Ability {
   private String name;
    private int damage;
    private String description;

    public MeteorStorm(String name) {
        this.name = name;
        this.damage = 100; 
        this.description = "summons meteors to crush enemies";
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
        return new MeteorStorm(this.name);
    }
    
}
