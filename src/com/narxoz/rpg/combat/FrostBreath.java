package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {
    @Override
    public String getName(){
        return "frost breath";
    }
    @Override
    public int getDamage(){
        return 40;
    }
    @Override
    public String getDescription (){
        return "a cold attack that slows enemies";
    }
    @Override
    public Ability clone(){
        return new FrostBreath();
    }
}
