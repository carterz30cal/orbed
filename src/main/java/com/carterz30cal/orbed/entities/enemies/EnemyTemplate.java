package com.carterz30cal.orbed.entities.enemies;

import org.bukkit.configuration.ConfigurationSection;

public class EnemyTemplate {

    public long health;
    public String enemyClass;

    public EnemyTemplate() {
        enemyClass = "com.carterz30cal.orbed.entities.enemies.EntityEnemyBasic";

        health = 1;
    }
    public EnemyTemplate(ConfigurationSection section) {
        enemyClass = "com.carterz30cal.orbed.entities.enemies." + section.getString("enemy-class", "EntityEnemyBasic");

        health = section.getLong("health", 1);
    }
}
