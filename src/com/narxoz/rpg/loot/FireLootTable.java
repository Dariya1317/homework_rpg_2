package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class FireLootTable implements LootTable {
    private List<String> items;
    public FireLootTable(){
        this.items = new ArrayList<>();
        this.items.add("Fire Gem");
        this.items.add("Dragon Scale");
    }
    private FireLootTable(List<String> items){
        this.items = new ArrayList<>(items);
    }
    @Override 
    public List<String> getItems(){
        return items;
    }    
    @Override 
    public int getGoldDrop(){
        return 100;
    }
    @Override
    public int getExperienceDrop(){
        return 250;
    }
    @Override
    public String getLootInfo(){
        return "drops items with a fire theme: " + items.toString();
    }
    @Override 
    public LootTable clone(){
        return new FireLootTable(this.items);
    }
}
