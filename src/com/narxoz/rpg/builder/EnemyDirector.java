package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    public Enemy createMinion(EnemyBuilder builder, EnemyComponentFactory factory) {
        return builder.setName("Weak Minion")
                      .setStats(100, 10, 5, 20)
                      .applyTheme(factory)
                      .build();
    }

    public Enemy createElite(EnemyBuilder builder, EnemyComponentFactory factory) {
        return builder.setName("Elite Warrior")
                      .setStats(500, 50, 25, 30)
                      .applyTheme(factory)
                      .build();
    }

    public Enemy createMiniBoss(EnemyBuilder builder, EnemyComponentFactory factory) {
        if (builder instanceof BossEnemyBuilder) {
            return ((BossEnemyBuilder) builder)
                    .setName("Mini Boss")
                    .setStats(5000, 150, 75, 40)
                    .applyTheme(factory)
                    .addPhase(1, 5000)
                    .addPhase(2, 2500)
                    .build();
        } else {
            return builder.setName("Mini Boss")
                         .setStats(5000, 150, 75, 40)
                         .applyTheme(factory)
                         .build();
        }
    }

    public Enemy createRaidBoss(EnemyBuilder builder, EnemyComponentFactory factory) {
        if (builder instanceof BossEnemyBuilder) {
            return ((BossEnemyBuilder) builder)
                    .setName("Ancient Dragon Boss")
                    .setStats(50000, 500, 200, 50)
                    .applyTheme(factory)
                    .addPhase(1, 50000)
                    .addPhase(2, 30000)
                    .addPhase(3, 15000)
                    .build();
        }
        throw new IllegalArgumentException("Raid boss requires BossEnemyBuilder!");
    }
    
}
