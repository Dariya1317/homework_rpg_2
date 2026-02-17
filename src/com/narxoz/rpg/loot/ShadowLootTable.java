package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {
    private List<String> items;
    public ShadowLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Shadow Essence");
        this.items.add("Dark Soul");
    }
    private ShadowLootTable(List<String> items) {
        this.items = new ArrayList<>(items); 
    }
    @Override
    public List<String> getItems() {
        return items;
    }
    @Override 
    public int getGoldDrop() { 
        return 200; 
    }
    @Override 
    public int getExperienceDrop() { 
        return 500; 
    }
    @Override 
    public String getLootInfo() { 
        return "drops shadow items: " + items; 
    }
    @Override 
    public LootTable clone() { 
        return new ShadowLootTable(this.items); 
    }
}
