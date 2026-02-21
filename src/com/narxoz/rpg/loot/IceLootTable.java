package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable  {
    private List<String> items;
    private int goldDrop;
    private int expDrop;

    public IceLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Ice Gem");         
        this.items.add("Frost Scale");     
        this.items.add("Ice Rune");        
        this.goldDrop = 120;
        this.expDrop = 300;
    }

    private IceLootTable(List<String> items, int goldDrop, int expDrop) {
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
        return "Ice theme loot: " + items + " | Gold: " + goldDrop + " | Exp: " + expDrop;
    }
    
    @Override 
    public LootTable clone() {
        return new IceLootTable(this.items, this.goldDrop, this.expDrop);
    }
    
}
