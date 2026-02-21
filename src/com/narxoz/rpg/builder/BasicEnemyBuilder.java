package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder{
    private String name;
    private int health = -1;
    private int damage = -1;
    private int defense = -1;
    private int speed = -1;
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private String element = "NONE";

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
        
        String factoryName = factory.getClass().getSimpleName();
        if (factoryName.contains("Fire")) {
            this.element = "FIRE";
        } else if (factoryName.contains("Ice")) {
            this.element = "ICE";
        } else if (factoryName.contains("Shadow")) {
            this.element = "SHADOW";
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
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Enemy must have a name!");
        }
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be positive!");
        }
        
        Goblin goblin = new Goblin(name);
        return goblin;
    }
    
}
