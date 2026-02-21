package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;

public interface Enemy {
    String getName();
    void setName(String name);
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();
    String getElement();
    List<Ability> getAbilities();
    LootTable getLootTable();
    
    void displayInfo();
    Enemy clone();
    default void multiplyStats(double multiplier) {
        throw new UnsupportedOperationException("multiplyStats not implemented");
    }
    
    default void setElement(String element) {
        throw new UnsupportedOperationException("setElement not implemented");
    }


}
