package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public interface EnemyBuilder {
    EnemyBuilder setName(String name);
    EnemyBuilder setStats(int hp, int dmg, int def, int spd);
    EnemyBuilder applyTheme(EnemyComponentFactory factory);
    EnemyBuilder addAbility(Ability ability);
    EnemyBuilder addPhase(int phase, int threshold);
    Enemy build();
    
}
