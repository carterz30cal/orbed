package com.carterz30cal.orbed.entities.enemies.generation.properties;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;

public abstract class EntityProperty {
    public abstract void loadProperty(ConfigurationSection section);
    public abstract void applyProperty(Entity entity);
}
