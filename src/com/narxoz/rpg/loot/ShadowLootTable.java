package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {
    private List<String> items;
    private int goldDrop;
    private int expDrop;

    public ShadowLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Shadow Gem");     
        this.items.add("Dark Essence");    
        this.items.add("Shadow Rune");    
        this.goldDrop = 200;
        this.expDrop = 500;
    }

    private ShadowLootTable(List<String> items, int goldDrop, int expDrop) {
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
        return "Shadow theme loot: " + items + " | Gold: " + goldDrop + " | Exp: " + expDrop;
    }
    
    @Override 
    public LootTable clone() { 
        return new ShadowLootTable(this.items, this.goldDrop, this.expDrop); 
    }
}
