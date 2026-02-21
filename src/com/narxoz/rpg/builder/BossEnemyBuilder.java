package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder implements EnemyBuilder{
    private String name;
    private int health = -1;
    private int damage = -1;
    private int defense = -1;
    private int speed = -1;
    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer, Integer> phases = new HashMap<>();
    private LootTable lootTable;
    private String aiBehavior = "AGGRESSIVE";
    private String element = "NONE";
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setStats(int hp, int dmg, int def, int spd) {
        this.health = hp;
        this.damage = dmg;
        this.defense = def;
        this.speed = spd;
        return this;
    }

    @Override
    public EnemyBuilder applyTheme(EnemyComponentFactory factory) {
        this.abilities = factory.createAbilities();
        this.lootTable = factory.createLootTable();
        this.aiBehavior = factory.createAIBehavior();
        
        if (factory instanceof FireComponentFactory) {
            this.element = "FIRE";
            this.canFly = true;
            this.hasBreathAttack = true;
            this.wingspan = 50;
        } else if (factory instanceof IceComponentFactory) {
            this.element = "ICE";
            this.canFly = true;
            this.hasBreathAttack = true;
            this.wingspan = 45;
        } else if (factory instanceof ShadowComponentFactory) {
            this.element = "SHADOW";
            this.canFly = false;
            this.hasBreathAttack = false;
            this.wingspan = 0;
        }
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phase, int threshold) {
        this.phases.put(phase, threshold);
        return this;
    }

    public BossEnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("enemy must have a name!");
        }
        if (health <= 0) {
            throw new IllegalArgumentException("health must be positive!");
        }
        if (damage <= 0) {
            throw new IllegalArgumentException("damage must be positive!");
        }

        int phase1 = phases.getOrDefault(1, health);
        int phase2 = phases.getOrDefault(2, health / 2);
        int phase3 = phases.getOrDefault(3, health / 4);

        return new DragonBoss(
            name, health, damage, defense, speed, element,
            abilities, phase1, phase2, phase3,
            lootTable, aiBehavior, canFly, hasBreathAttack, wingspan
        );
    }
    
}
