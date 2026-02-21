package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class Skeleton implements Enemy {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private String aiBehavior;
    private List<Ability> abilities;
    private LootTable lootTable;

    public Skeleton(String name) {
        this.name = name;
        this.health = 80;
        this.damage = 20;
        this.defense = 10;
        this.speed = 25;
        this.element = "NONE";
        this.aiBehavior = "RELENTLESS";
        this.abilities = new ArrayList<>();
    }

    private Skeleton(String name, int health, int damage, int defense, int speed, 
                     String element, String aiBehavior, List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.aiBehavior = aiBehavior;
        this.abilities = abilities;
        this.lootTable = lootTable;
    }
    @Override
public void setName(String name) {
    this.name = name;
}
    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }
    @Override public String getElement() { return element; }
    @Override public List<Ability> getAbilities() { return abilities; }
    @Override public LootTable getLootTable() { return lootTable; }
    public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Skeleton) ===");
        System.out.println("Health: " + health + " | Damage: " + damage 
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " (Damage: " + a.getDamage() + ") - " + a.getDescription());
        }
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }

    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int)(this.health * multiplier);
        this.damage = (int)(this.damage * multiplier);
        this.defense = (int)(this.defense * multiplier);
        this.speed = (int)(this.speed * multiplier);
    }

    @Override
    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            clonedAbilities.add(a.clone());
        }
        LootTable clonedLoot = (this.lootTable != null) ? this.lootTable.clone() : null;
        return new Skeleton(this.name, this.health, this.damage, this.defense, this.speed,
                            this.element, this.aiBehavior, clonedAbilities, clonedLoot);
    }
}
