package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {
    private String name;
    private int damage;
    private String description;

    public FlameBreath(String name) {
        this.name = name;
        this.damage = 50;
        this.description = "Roasts heroes with a cone of fire";
    }
    
    /*  
    private FlameBreath(String name, int damage, String description) {
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
    public String getDescription(){
        return description;
    }
    @Override 
    public Ability clone(){
        return new FlameBreath(this.name);

    }

    
}
