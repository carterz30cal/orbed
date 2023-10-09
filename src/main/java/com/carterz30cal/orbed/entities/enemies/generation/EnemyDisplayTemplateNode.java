package com.carterz30cal.orbed.entities.enemies.generation;

import com.carterz30cal.orbed.entities.enemies.generation.properties.EntityProperty;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This is how we will allow for cool enemy shapes using only YML files.
 * All entities which make up an enemy (besides the status display armour stand) should be somewhere in this tree.
 *
 * @author carterz30cal
 * @version 1.0.0
 * @since 1.0.0
 */
public class EnemyDisplayTemplateNode {
    public EnemyDisplayTemplateNode parent;
    public List<EnemyDisplayTemplateNode> children = new ArrayList<>();

    public EntityType entityType;
    public Vector parentOffset;
    //public Vector eulerRotation;
    public boolean invisible;
    public List<EntityProperty> properties = new ArrayList<>();

    public EnemyDisplayTemplateNode(@NotNull ConfigurationSection section) {
        entityType = EntityType.valueOf(section.getString("entity-type"));
        parentOffset = section.getVector("parent-offset", new Vector(0,0,0));
        //eulerRotation = section.getVector("euler-rotation", new Vector(0,0,0));
        invisible = section.getBoolean("invisible", false);

        for (String property : section.getStringList("properties")) {
            String className = "com.carterz30cal.orbed.entities.enemies.generation.properties." + property;
            try {
                EntityProperty propClass = (EntityProperty)
                        Class.forName(className)
                                .getDeclaredConstructor(ConfigurationSection.class)
                                .newInstance(section.getConfigurationSection("properties." + property));
                properties.add(propClass);
            } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException |
                     InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        ConfigurationSection children = section.getConfigurationSection("children");
        if (children != null) {
            for (String child : children.getKeys(false)) {
                EnemyDisplayTemplateNode node = new EnemyDisplayTemplateNode(Objects.requireNonNull(children.getConfigurationSection(child)));
                node.parent = this;
            }
        }
    }

    public EnemyDisplayTemplateNode(EntityType entityType) {
        this.entityType = entityType;
        this.parentOffset = new Vector(0,0,0);
        //this.eulerRotation = new Vector(0,0,0);
        this.invisible = false;
    }

    /**
     *
     * Recursively generates this node as an EnemyDisplayNode with all children
     * attached. Calling this on the parent node should be all that is necessary.
     *
     * @param location where in the world should this be generated?
     * @param parent parent node, not normally required for manual call.
     * @return the EnemyDisplayNode, with children attached.
     */
    public EnemyDisplayNode getNewNode(@NotNull Location location, @Nullable EnemyDisplayNode parent) {
        if (location.getWorld() == null) return null;
        Entity entity = location.getWorld().spawnEntity(location, entityType);

        for (EntityProperty property : properties) property.applyProperty(entity);

        EnemyDisplayNode that = new EnemyDisplayNode(entity, parent);
        List<EnemyDisplayNode> hobgoblins = new ArrayList<>();
        for (EnemyDisplayTemplateNode hobgoblinSperm : children) {
            hobgoblins.add(getNewNode(location.clone().add(hobgoblinSperm.parentOffset), that));
        }

        that.children = hobgoblins;
        return that;
    }
}
