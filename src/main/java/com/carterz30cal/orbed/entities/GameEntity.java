package com.carterz30cal.orbed.entities;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Abstract class for all ENTITIES that appear in the game world.
 * Should include temp entities, monsters, portals.
 * Any entities interacted with that do not derive from GameEntity will
 * be assumed to be VANILLA entities and will have unique interactions.
 *
 * @author carterz30cal
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class GameEntity {
    public static Map<UUID, GameEntity> entities = new HashMap<>();
    public final UUID identifier;

    public Health healthSystem;

    public GameEntity() {
        identifier = UUID.randomUUID();
    }

    public abstract void loadData(ConfigurationSection section);
    public abstract void saveData(ConfigurationSection section);
    protected abstract void register();
    protected abstract void deregister();
    protected abstract void tick();

    /**
     * Probably not the best implementation of this idea.
     * Should only really return false for players and the like cause the
     * plugin should not be able to DESTROY a player.
     * @return Whether this entity is destroyable or not.
     */
    protected boolean isDestroyable() {
        return true;
    }

    public final void onTick() {
        tick();
    }

    public void onKill() {
        destroy();
    }

    /**
     * Attempts to destroy the entity.
     * Not guaranteed to work, if isDestroyable() returns false.
     * In general, should be used less than subset methods on more specific classes, like
     * damage etc.
     */
    public final void destroy() {
        if (!isDestroyable()) return;
        deregister();
    }
}
