package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemonLord implements Enemy {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canSummon;
    private int auraOfFear;

    public DemonLord(String name, int health, int damage, int defense, int speed, 
                     String element, List<Ability> abilities,
                     int phase1Threshold, int phase2Threshold, int phase3Threshold,
                     LootTable lootTable, String aiBehavior,
                     boolean canSummon, int auraOfFear) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        this.phases = new HashMap<>();
        this.phases.put(1, phase1Threshold);
        this.phases.put(2, phase2Threshold);
        this.phases.put(3, phase3Threshold);
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canSummon = canSummon;
        this.auraOfFear = auraOfFear;
    }

    private DemonLord(String name, int health, int damage, int defense, int speed,
                      String element, List<Ability> abilities, Map<Integer, Integer> phases,
                      LootTable lootTable, String aiBehavior,
                      boolean canSummon, int auraOfFear) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities;
        this.phases = phases;
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canSummon = canSummon;
        this.auraOfFear = auraOfFear;
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

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Demon Lord) ===");
        System.out.println("Health: " + health + " | Damage: " + damage 
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Special: " + (canSummon ? "Can Summon Minions" : "Cannot Summon") 
                + " | Aura of Fear: " + auraOfFear);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " (Damage: " + a.getDamage() + ") - " + a.getDescription());
        }
        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey() + ": triggers at " + phase.getValue() + " HP");
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
        this.auraOfFear = (int)(this.auraOfFear * multiplier);
        
        Map<Integer, Integer> newPhases = new HashMap<>();
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            newPhases.put(phase.getKey(), (int)(phase.getValue() * multiplier));
        }
        this.phases = newPhases;
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
        
        Map<Integer, Integer> clonedPhases = new HashMap<>(this.phases);
        LootTable clonedLoot = (this.lootTable != null) ? this.lootTable.clone() : null;
        
        return new DemonLord(
            this.name, this.health, this.damage, this.defense, this.speed,
            this.element, clonedAbilities, clonedPhases,
            clonedLoot, this.aiBehavior, this.canSummon, this.auraOfFear
        );
    }
}
