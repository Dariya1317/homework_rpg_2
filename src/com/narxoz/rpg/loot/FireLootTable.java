package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class FireLootTable implements LootTable {
    private List<String> items;
    private int goldDrop;
    private int expDrop;

    public FireLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Fire Gem");
        this.items.add("Dragon Scale");
        this.items.add("Flame Rune");  
        this.goldDrop = 100;
        this.expDrop = 250;
    }
    
    private FireLootTable(List<String> items, int goldDrop, int expDrop) {
        this.items = new ArrayList<>(items);
        this.goldDrop = goldDrop;
        this.expDrop = expDrop;
    }
    
    @Override 
    public List<String> getItems() {
        return items;
    }    
    
    @Override 
    public int getGoldDrop() {
        return goldDrop;
    }
    
    @Override
    public int getExperienceDrop() {
        return expDrop;
    }
    
    @Override
    public String getLootInfo() {
        return "Fire theme loot: " + items + " | Gold: " + goldDrop + " | Exp: " + expDrop;
    }
    
    @Override 
    public LootTable clone() {
        return new FireLootTable(this.items, this.goldDrop, this.expDrop);
    }
}
