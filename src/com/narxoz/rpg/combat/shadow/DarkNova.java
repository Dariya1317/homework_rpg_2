package com.narxoz.rpg.combat.shadow;

import com.narxoz.rpg.combat.Ability;

public class DarkNova implements Ability {
    private String name;
    private int damage;
    private String description;

    public DarkNova(String name) {
        this.name = name;
        this.damage = 120;
        this.description = "dark explosion that destroys light";
    }

    @Override public String getName() { return name; }
    @Override public int getDamage() { return damage; }
    @Override public String getDescription() { return description; }

    @Override 
    public Ability clone() {
        return new DarkNova(this.name);
    }
    
}
