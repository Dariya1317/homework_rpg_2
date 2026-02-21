package com.narxoz.rpg;

import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.enemy.Orc;
import com.narxoz.rpg.enemy.Skeleton;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {
    
   public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("FIRE THEME:");
        System.out.println("Abilities:");
        for (Ability a : fireFactory.createAbilities()) {
            System.out.println("  - " + a.getName() + " (Damage: " + a.getDamage() + ") - " + a.getDescription());
        }
        System.out.println("Loot: " + fireFactory.createLootTable().getLootInfo());
        System.out.println("AI: " + fireFactory.createAIBehavior());
        System.out.println();

        System.out.println("ICE THEME:");
        System.out.println("Abilities:");
        for (Ability a : iceFactory.createAbilities()) {
            System.out.println("  - " + a.getName() + " (Damage: " + a.getDamage() + ") - " + a.getDescription());
        }
        System.out.println("Loot: " + iceFactory.createLootTable().getLootInfo());
        System.out.println("AI: " + iceFactory.createAIBehavior());
        System.out.println();

        System.out.println("SHADOW THEME:");
        System.out.println("Abilities:");
        for (Ability a : shadowFactory.createAbilities()) {
            System.out.println("  - " + a.getName() + " (Damage: " + a.getDamage() + ") - " + a.getDescription());
        }
        System.out.println("Loot: " + shadowFactory.createLootTable().getLootInfo());
        System.out.println("AI: " + shadowFactory.createAIBehavior());
        System.out.println();

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        Enemy fireDragon = new BossEnemyBuilder()
            .setName("Ancient Fire Dragon")
            .setStats(50000, 500, 200, 50)
            .applyTheme(fireFactory)
            .addPhase(1, 50000)
            .addPhase(2, 30000)
            .addPhase(3, 15000)
            .build();
        
        fireDragon.displayInfo();
        System.out.println();

        Enemy shadowDemon = new BossEnemyBuilder()
            .setName("Shadow Demon Lord")
            .setStats(75000, 800, 300, 60)
            .applyTheme(shadowFactory)
            .addPhase(1, 75000)
            .addPhase(2, 40000)
            .addPhase(3, 20000)
            .build();
        
        shadowDemon.displayInfo();
        System.out.println();

        EnemyDirector director = new EnemyDirector();
        Enemy miniBoss = director.createMiniBoss(new BossEnemyBuilder(), fireFactory);
        Enemy raidBoss = director.createRaidBoss(new BossEnemyBuilder(), iceFactory);

        System.out.println("Mini Boss created by Director:");
        miniBoss.displayInfo();
        System.out.println();
        
        System.out.println("Raid Boss created by Director:");
        raidBoss.displayInfo();
        System.out.println();

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegistry registry = new EnemyRegistry();
        
        System.out.println("--- Registering Base Templates ---");
        
        Goblin baseGoblin = new Goblin("Forest Goblin");
        Orc baseOrc = new Orc("Mountain Orc");
        Skeleton baseSkeleton = new Skeleton("Dungeon Skeleton");
        
        registry.registerTemplate("goblin", baseGoblin);
        registry.registerTemplate("orc", baseOrc);
        registry.registerTemplate("skeleton", baseSkeleton);
        registry.registerTemplate("fire-dragon", fireDragon);
        registry.registerTemplate("shadow-demon", shadowDemon);
        
        
        System.out.println("All registered templates:");
        registry.listTemplates();
        System.out.println();

        System.out.println("--- Creating DIFFICULTY VARIANTS via Cloning ---");
        
        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2.0);
        eliteGoblin.setName("Elite Goblin");
        
        Enemy championGoblin = registry.createFromTemplate("goblin");
        championGoblin.multiplyStats(5.0);
        championGoblin.setName("Champion Goblin");
        
        Enemy goblinKing = registry.createFromTemplate("goblin");
        goblinKing.multiplyStats(10.0);
        goblinKing.setName("Goblin King");
        
        System.out.println("GOBLIN VARIANTS:");
        System.out.println("  Base Goblin Health: " + baseGoblin.getHealth());
        System.out.println("  Elite Goblin Health: " + eliteGoblin.getHealth() + " (2x)");
        System.out.println("  Champion Goblin Health: " + championGoblin.getHealth() + " (5x)");
        System.out.println("  Goblin King Health: " + goblinKing.getHealth() + " (10x)");
        System.out.println();

        Enemy eliteOrc = registry.createFromTemplate("orc");
        eliteOrc.multiplyStats(2.0);
        eliteOrc.setName("Elite Orc");
        
        Enemy orcWarlord = registry.createFromTemplate("orc");
        orcWarlord.multiplyStats(3.0);
        orcWarlord.setName("Orc Warlord");
        
        System.out.println("ORC VARIANTS:");
        System.out.println("  Base Orc Health: " + baseOrc.getHealth());
        System.out.println("  Elite Orc Health: " + eliteOrc.getHealth() + " (2x)");
        System.out.println("  Orc Warlord Health: " + orcWarlord.getHealth() + " (3x)");
        System.out.println();

        Enemy eliteSkeleton = registry.createFromTemplate("skeleton");
        eliteSkeleton.multiplyStats(2.0);
        eliteSkeleton.setName("Elite Skeleton");
        
        Enemy skeletonLord = registry.createFromTemplate("skeleton");
        skeletonLord.multiplyStats(4.0);
        skeletonLord.setName("Skeleton Lord");
        
        System.out.println("SKELETON VARIANTS:");
        System.out.println("  Base Skeleton Health: " + baseSkeleton.getHealth());
        System.out.println("  Elite Skeleton Health: " + eliteSkeleton.getHealth() + " (2x)");
        System.out.println("  Skeleton Lord Health: " + skeletonLord.getHealth() + " (4x)");
        System.out.println();

        System.out.println("--- Creating ELEMENTAL VARIANTS via Cloning ---");
        
        Enemy iceDragon = registry.createFromTemplate("fire-dragon");
        iceDragon.setElement("ICE");
        iceDragon.setName("Ice Dragon");
        
        Enemy shadowDragon = registry.createFromTemplate("fire-dragon");
        shadowDragon.setElement("SHADOW");
        shadowDragon.setName("Shadow Dragon");
        
        System.out.println("DRAGON VARIANTS:");
        System.out.println("  Original Fire Dragon Element: " + fireDragon.getElement());
        System.out.println("  Ice Dragon Element: " + iceDragon.getElement());
        System.out.println("  Shadow Dragon Element: " + shadowDragon.getElement());
        System.out.println();

        Enemy fireDemon = registry.createFromTemplate("shadow-demon");
        fireDemon.setElement("FIRE");
        fireDemon.setName("Fire Demon");
        
        Enemy iceDemon = registry.createFromTemplate("shadow-demon");
        iceDemon.setElement("ICE");
        iceDemon.setName("Ice Demon");
        
        System.out.println("DEMON VARIANTS:");
        System.out.println("  Original Shadow Demon Element: " + shadowDemon.getElement());
        System.out.println("  Fire Demon Element: " + fireDemon.getElement());
        System.out.println("  Ice Demon Element: " + iceDemon.getElement());
        System.out.println();

        System.out.println("--- Creating REGIONAL VARIANTS via Cloning ---");
        
        Enemy forestGoblin = registry.createFromTemplate("goblin");
        forestGoblin.setName("Forest Goblin");
        forestGoblin.multiplyStats(1.2);
        
        Enemy caveGoblin = registry.createFromTemplate("goblin");
        caveGoblin.setName("Cave Goblin");
        caveGoblin.multiplyStats(1.5);
        
        Enemy swampGoblin = registry.createFromTemplate("goblin");
        swampGoblin.setName("Swamp Goblin");
        swampGoblin.multiplyStats(1.3);
        
        System.out.println("GOBLIN REGIONAL VARIANTS:");
        System.out.println("  " + forestGoblin.getName() + " - Health: " + forestGoblin.getHealth());
        System.out.println("  " + caveGoblin.getName() + " - Health: " + caveGoblin.getHealth());
        System.out.println("  " + swampGoblin.getName() + " - Health: " + swampGoblin.getHealth());
        System.out.println();

        System.out.println("--- DEEP COPY Verification ---");
        
        Goblin testOriginal = new Goblin("Test Goblin");
        testOriginal.setElement("FIRE");
        testOriginal.getAbilities().add(fireFactory.createAbilities().get(0));
        
        registry.registerTemplate("test", testOriginal);
        
        System.out.println("ORIGINAL created with:");
        System.out.println("  Element: " + testOriginal.getElement());
        System.out.println("  Health: " + testOriginal.getHealth());
        System.out.println("  Abilities count: " + testOriginal.getAbilities().size());
        System.out.println();

        Enemy testClone = registry.createFromTemplate("test");
        
        System.out.println("MODIFYING CLONE:");
        testClone.setElement("ICE");
        testClone.multiplyStats(2.0);
        testClone.getAbilities().clear();
        testClone.getAbilities().add(iceFactory.createAbilities().get(0));
        
        System.out.println("  Clone now has:");
        System.out.println("    Element: " + testClone.getElement());
        System.out.println("    Health: " + testClone.getHealth());
        System.out.println("    Abilities: " + testClone.getAbilities().size());
        System.out.println();

        System.out.println("CHECKING ORIGINAL:");
        System.out.println("  Original element: " + testOriginal.getElement() + " (UNCHANGED)");
        System.out.println("  Original health: " + testOriginal.getHealth() + " (UNCHANGED)");
        System.out.println("  Original abilities: " + testOriginal.getAbilities().size() + " (UNCHANGED)");
        System.out.println();
        
        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        EnemyComponentFactory shadowFactory2 = new ShadowComponentFactory();

        Enemy demonLord = new BossEnemyBuilder()
            .setName("Demon Lord")
            .setStats(75000, 800, 300, 60)
            .applyTheme(shadowFactory2)
            .addPhase(1, 75000)
            .addPhase(2, 40000)
            .addPhase(3, 20000)
            .build();

        registry.registerTemplate("demon-lord", demonLord);

        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        greaterDemon.multiplyStats(1.8);
        greaterDemon.setName("Greater Demon");
        
        Enemy demonPrince = registry.createFromTemplate("demon-lord");
        demonPrince.multiplyStats(2.5);
        demonPrince.setName("Demon Prince");

        System.out.println("Demon Lord (built with Abstract Factory + Builder):");
        demonLord.displayInfo();
        System.out.println();
        
        System.out.println("Greater Demon (cloned with Prototype - 1.8x stats):");
        greaterDemon.displayInfo();
        System.out.println();
        
        System.out.println("Demon Prince (cloned with Prototype - 2.5x stats):");
        demonPrince.displayInfo();
        System.out.println();

        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println();
        System.out.println("\n=== Demo Complete ===");
    }
}
