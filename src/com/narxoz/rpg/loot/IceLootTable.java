package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable  {
    private List<String> items;

    public IceLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Frost Gem");
        this.items.add("Frozen Bone");
    }

    private IceLootTable(List<String> items) {
        this.items = new ArrayList<>(items);
    }

    @Override public List<String> getItems() { 
        return items;
    }
    @Override public int getGoldDrop() { 
        return 120;
    }
    @Override public int getExperienceDrop() { 
        return 300; 
    }
    @Override public String getLootInfo() { 
        return "drops icy items: " + items; 
    }
    @Override 
    public LootTable clone() {
        return new IceLootTable(this.items);
    }
    
}
