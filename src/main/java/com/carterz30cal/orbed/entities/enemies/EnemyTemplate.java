package com.carterz30cal.orbed.entities.enemies;

import com.carterz30cal.orbed.entities.enemies.generation.EnemyDisplayTemplateNode;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.EntityType;

import java.util.Objects;

public class EnemyTemplate {

    public long health;
    public String enemyClass;
    public EnemyDisplayTemplateNode displayRoot;

    public EnemyTemplate() {
        enemyClass = "com.carterz30cal.orbed.entities.enemies.EntityEnemyBasic";
        displayRoot = new EnemyDisplayTemplateNode(EntityType.ZOMBIE);
        health = 1;
    }
    public EnemyTemplate(ConfigurationSection section) {
        enemyClass = "com.carterz30cal.orbed.entities.enemies." + section.getString("enemy-class", "EntityEnemyBasic");

        health = section.getLong("health", 1);

        if (section.contains("entity-type")) {
            displayRoot = new EnemyDisplayTemplateNode(EntityType.valueOf(section.getString("entity-type")));
        }
        else if (section.contains("entity-root")) {
            displayRoot = new EnemyDisplayTemplateNode(Objects.requireNonNull(section.getConfigurationSection("entity-root")));
        }
    }
}
